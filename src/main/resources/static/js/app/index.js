var main={
    init : function(){
        var _this = this;

        $('#btn-save').on('click',function(){
            _this.saveComment();
        });
        $('#content').on('keydown', function (e) {
            if (e.keyCode === 13) { 
                e.preventDefault(); 
                $('#btn-save').click(); 
            }
        });
    },
    saveComment : function () {
        var data = {
            category: $('#category').val(),
            content: $('#content').val()
        };
        if (!data.content) { 
            alert('내용을 입력해주세요');
            return;
        }
        $.ajax({
            type: 'POST',
            url: '/api/v1/comment/save',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('Comment saved');
            window.location.href = `/${data.category}`;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}
main.init();