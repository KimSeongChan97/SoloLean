document.addEventListener('DOMContentLoaded', function() {
    const selectAllCheckbox = document.getElementById('selectAll');
    const itemCheckboxes = document.querySelectorAll('.itemCheckbox');
    const updateForm = document.getElementById('updateForm');
    const updateButton = document.getElementById('updateButton');
    const deleteButton = document.getElementById('deleteButton');

    // 전체 선택/해제 기능
    selectAllCheckbox.addEventListener('change', function() {
        itemCheckboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });

    // 개별 체크박스 변경 시 전체 선택 체크박스 상태 업데이트
    itemCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function() {
            const allChecked = Array.from(itemCheckboxes).every(cb => cb.checked);
            selectAllCheckbox.checked = allChecked;
        });
    });

    // 파일 수정 버튼 클릭 시
    updateButton.addEventListener('click', function() {
        const selectedFiles = Array.from(itemCheckboxes).filter(cb => cb.checked).map(cb => cb.value);
        if (selectedFiles.length === 0) {
            alert('수정할 파일을 선택하세요.');
            return;
        }
        if (selectedFiles.length > 1) {
            alert('하나의 파일만 선택하세요.');
            return;
        }

        const fileSeq = selectedFiles[0];
        const formData = new FormData(updateForm);
        formData.append('seq', fileSeq);

        fetch('../imageboard/updateFile.do', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('파일이 성공적으로 수정되었습니다.');
                window.location.reload();
            } else {
                alert('파일 수정에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('파일 수정 중 오류:', error);
            alert('파일 수정 중 오류가 발생했습니다.');
        });
    });

    // 파일 삭제 버튼 클릭 시
    deleteButton.addEventListener('click', function() {
        const selectedFiles = Array.from(itemCheckboxes).filter(cb => cb.checked).map(cb => cb.value);
        if (selectedFiles.length === 0) {
            alert('삭제할 파일을 선택하세요.');
            return;
        }

        if (!confirm('선택한 파일을 삭제하시겠습니까?')) {
            return;
        }

        const formData = new FormData();
        selectedFiles.forEach(seq => formData.append('selectedSeq', seq));

        fetch('../imageboard/imageboardDelete.do', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                alert('선택한 파일이 성공적으로 삭제되었습니다.');
                window.location.reload();
            } else {
                alert('파일 삭제에 실패했습니다.');
            }
        })
        .catch(error => {
            console.error('파일 삭제 중 오류 발생:', error);
            alert('파일 삭제 중 오류가 발생했습니다.');
        });
    });
});
