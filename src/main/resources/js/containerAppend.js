(function ($) {
    var buttonContainer = $('#container');

    function addToContainer(num, container) {
        if (num < 0) return;

        var openButton = '<button type="button">';
        var closeButton = '</button>';

        for (var i = 1; i <= num; i++) {
            var template = openButton + i + closeButton;
            var elem = $(template);
            container.append(elem);

            //function createCallback(id) {
            //    return function callback() {
            //        alert("clicked on button: " + id);
            //    }
            //}
            //
            ////elem.click(createCallback(i));
            //var onButtonClick = function onButtonClick(id) {
            //    return alert.apply(null, ["clicked on button: " + id]);
            //};
            //elem.click((onButtonClick)(i));

            (function (id) {
                elem.click(function () {
                    alert("clicked on button: " + id);
                });
            })(i)
        }
    }

    addToContainer(3, buttonContainer);
})($);