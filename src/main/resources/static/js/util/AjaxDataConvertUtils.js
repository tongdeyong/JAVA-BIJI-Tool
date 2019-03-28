/**
 *构建ajax参数
 **/
define(function (require, exports, module) {

    jQuery = $;
    var rbracket = /\[\]$/;

    var buildParams = function (prefix, obj, traditional, add) {
        var name;

        if (Array.isArray(obj)) {

            // Serialize array item.
            jQuery.each(obj, function (i, v) {
                if (traditional || rbracket.test(prefix)) {

                    // Treat each array item as a scalar.
                    add(prefix, v);

                } else {

                    // Item is non-scalar (array or object), encode its numeric index.
                    buildParams(
                        prefix + "[" + i + "]",
                        v,
                        traditional,
                        add
                    );
                }
            });

        } else if (!traditional && jQuery.type(obj) === "object") {

            // Serialize object item.
            for (name in obj) {
                if (obj.hasOwnProperty(name)) {
                    buildParams(prefix + "." + name, obj[name], traditional, add);
                }
            }

        } else {

            // Serialize scalar item.
            add(prefix, obj);
        }
    };

    var param = function (a, traditional) {
        var prefix,
            s = [],
            add = function (key, valueOrFunction) {

                // If value is a function, invoke it and use its return value
                var value = jQuery.isFunction(valueOrFunction) ?
                    valueOrFunction() :
                    valueOrFunction;

                    if(value != null){
                        s[s.length] = encodeURIComponent(key) + "=" +
                        encodeURIComponent(value == null ? "" : value);
                    }
            };

        // If an array was passed in, assume that it is an array of form elements.
        if (Array.isArray(a) || ( a.jquery && !jQuery.isPlainObject(a) )) {

            // Serialize the form elements
            $.each(a, function () {
                add(this.name, this.value);
            });

        } else {
            // If traditional, encode the "old" way (the way 1.3.2 or older
            // did it), otherwise encode params recursively.
            for (prefix in a) {
                if (a.hasOwnProperty(prefix)) {
                    buildParams(prefix, a[prefix], traditional, add);
                }
            }
        }
        // Return the resulting serialization
        return s.join("&");
    };
    return {
        convert: param
    };
});