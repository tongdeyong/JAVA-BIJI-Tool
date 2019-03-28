define(function (require, exports, module) {

    var Handlebars = null;

    var templates = [];

    //编译模板
    var compileHandlebarsTemplate = function (templateStr) {
        if (Handlebars == null) {

            Handlebars = require('../dist/handlebars-v4.1.1.js');
        }
        return Handlebars.compile(templateStr);
    };


    //寻找模板
    var compileTemplate = function (template) {
        var $templateScript = $('#' + template);
        var type = $templateScript.attr('type');
        if (type === 'text/x-handlebars-template') {
            return compileHandlebarsTemplate($templateScript.html());
        }
        return null;
    };

    //执行，得到已编译的html
    var render = function (template, data) {
        var templateFun = templates[template];
        if (!templateFun) {
            templateFun = compileTemplate(template);
            templates[template] = templateFun;
        }
        if (!templateFun) {
            throw 'template not found:' + template;
        }
        return templateFun(data);

    };

    exports.render = render;

});