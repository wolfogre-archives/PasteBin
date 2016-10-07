/**
 * Created by wolfogre on 10/6/16.
 */
$(document).ready(function(){
    $.get('location?ip=' + $("#ip").text(), function(data){
        $('#location-to-show').text(data);
        $('#location').val(data);
    });
});
