$(document).ready(function() {
    // Update button click
    $('.update-btn').click(function() {
        const reviewId = $(this).data('id');
        window.location.href = '/review/update?reviewId=' + reviewId;
    });

    // Delete button click
    $('.delete-btn').click(function() {
        const reviewId = $(this).data('id');
        if (confirm('Are you sure you want to delete this review?')) {
            $.ajax({
                url: '/review/delete',
                type: 'POST',
                data: { reviewId: reviewId },
                success: function(response) {
                    alert('Review deleted successfully!');
                    location.reload(); // Refresh page after deletion
                },
                error: function(err) {
                    alert('Error deleting review');
                }
            });
        }
    });
});
