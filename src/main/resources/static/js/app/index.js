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
        $('#btn-delete').on('click',function(){
            _this.deleteComment();
        });
        $('#btn-update').on('click',function(){
            _this.updateComment();
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
    },

    deleteComment : function() {
        var id = $('#id').val();
        var category = $('#category').val();
        $('#delete-modal').modal('show');
        $('#confirm-delete-button').on('click', function () {
            $.ajax({
                type:'DELETE',
                url: '/api/v1/comment/'+id,
                dataType : 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(id)
            }).done(function(){
                alert('Comment deleted');
                window.location.href= `/${category}`;
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
            $('#confirm-delete-modal').modal('hide');
        });
    },
     updateComment : function() {
         var content = $('#content').val();
         var id = $('#id').val();
         var category = $('#category').val();
         $.ajax({
             type: 'PUT',
             url: '/api/v1/comment/'+id,
             dataType: 'json',
             contentType:'application/json; charset=utf-8',
             data: content
         }).done(function(){
             alert('Updated Successfully');
             window.location.href = `/${category}`;
         }).fail(function(error){
         alert(JSON.stringify(error));
         });
     }


}
main.init();