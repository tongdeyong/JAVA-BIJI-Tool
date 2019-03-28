$(function () {
    $('#add-class-button').on('click', function () {
        var $tpl = $('#box_template');
        var source = $tpl.text();
        var template = Handlebars.compile(source);
        var html = template({});
        $('#add-buttons').html(html);
        $('#popBox').show();
        $('#popLayer').show();
    })
});