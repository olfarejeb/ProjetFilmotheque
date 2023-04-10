$(function() {
  
    $('#test').submit(function() {
        if (!$("#acteurs option:selected").val() == -1)  
            alert('Pas bon');
        else
            alert('ok');
    });
});