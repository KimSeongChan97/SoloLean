import React, { useState, useCallback } from 'react';

const List = () => {
  // nextId를 상태로 관리합니다. 아티스트 추가 시마다 증가해야 하므로 상태로 설정합니다.
  const [nextId, setNextId] = useState(3);

  // 새로운 아티스트의 이름을 저장하는 상태입니다. 입력 필드의 값을 제어하기 위해 사용합니다.
  const [name, setName] = useState('');

  // 아티스트 목록을 상태로 관리합니다. 초기값은 세 명의 유명 조각가입니다.
  const [artists, setArtists] = useState([
    { id: 0, name: 'Marta Colvin Andrade' },
    { id: 1, name: 'Lamidi Olonade Fakeye' },
    { id: 2, name: 'Louise Nevelson' },
  ]);

  // 새로운 아티스트를 목록에 추가하는 함수입니다. 메모이제이션을 통해 성능 최적화를 합니다.
  const addArtist = useCallback(() => {
    // 입력된 이름에서 공백을 제거한 후 빈 문자열이 아닌지 확인합니다.
    if (name.trim()) {
      // 아티스트 목록을 업데이트합니다. 현재 목록을 복사하고 새로운 아티스트를 추가합니다.
      setArtists([...artists, { id: nextId, name }]);

      // nextId 값을 1 증가시켜서 다음 아티스트에 대한 고유 id를 준비합니다.
      setNextId(nextId + 1);

      // 아티스트가 추가된 후 입력 필드를 비웁니다.
      setName('');
    }
  }, [name, artists, nextId]); // name, artists, nextId가 변경될 때마다 함수가 업데이트됩니다.

  // 특정 아티스트를 목록에서 삭제하는 함수입니다. 메모이제이션을 사용하여 불필요한 렌더링을 방지합니다.
  const deleteArtist = useCallback((id) => {
    // id가 일치하지 않는 아티스트들만 남기고 목록을 필터링하여 업데이트합니다.
    setArtists(artists.filter(artist => artist.id !== id));
  }, [artists]); // artists 배열이 변경될 때마다 함수가 업데이트됩니다.

  return (
    <div>
      {/* 제목을 표시합니다. */}
      <h1>Inspiring sculptors:</h1>

      {/* 아티스트 이름을 입력받는 필드입니다. value 속성을 통해 상태와 연결되어 있으며, 상태를 업데이트하는 onChange 핸들러를 설정했습니다. */}
      <input
        value={name} // name 상태가 입력 필드의 값으로 설정됩니다.
        onChange={e => setName(e.target.value)} // 입력 값이 변경될 때마다 name 상태가 업데이트됩니다.
        onKeyDown={e => {
          // 사용자가 Enter 키를 눌렀을 때 addArtist 함수를 호출하여 아티스트를 추가합니다.
          if (e.key === 'Enter') {
            addArtist();
          }
        }}
      />

      {/* 아티스트 추가 버튼입니다. 클릭 시 addArtist 함수가 호출됩니다. */}
      <button onClick={addArtist}>Add</button>

      {/* 아티스트 목록을 렌더링합니다. 각 아티스트는 고유의 id를 가진 <li>로 표시됩니다. */}
      <ul>
        {artists.map(artist => (
          <li key={artist.id}>
            {artist.name} {/* 아티스트 이름을 표시합니다. */}
            {' '}
            {/* 각 아티스트 항목에 삭제 버튼을 추가합니다. 클릭 시 해당 아티스트가 목록에서 삭제됩니다. */}
            <button onClick={() => deleteArtist(artist.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default List;
