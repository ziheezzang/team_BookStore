/**
 * 
 */
$("#comment-write-btn").click(function (){
        console.log('댓글 등록 버튼 클릭');
        const book_id = '[[${review.book_id}]]';
        const user_id = $("#user_id").val();
        const contents = $("#contents").val();
        $.ajax({
            type: 'post',
            url: 'review/getReviewList',
            data: {
                'book_id': book_id,
                'user_id': user_id,
                'contents': contents
            },
            data_type: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (){
                alert('땡!!!')
            }
        });
    });