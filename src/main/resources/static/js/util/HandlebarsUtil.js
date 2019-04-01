define(function (require, exports, module) {

    require('../dist/handlebars-v4.1.0.js');

    var templates = [];

    //寻找模板
    var compileTemplate = function (template) {
        var $templateScript = $('#' + template);
        var type = $templateScript.attr('type');
        //注册索引+1的helper
        Handlebars.registerHelper("addOne", function (index) {
            //返回+1之后的结果
            return index + 1;
        });
        if (type === 'text/x-handlebars-template') {
            return Handlebars.compile($templateScript.html());
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