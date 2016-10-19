/**
 * Created by wolfogre on 10/6/16.
 */
$(document).ready(function(){
    $.get('location?ip=' + $("#ip").text(), function(data){
        $('#location-to-show').text(data);
        $('#location').val(data);
    });
});

//some default pre init
var Countly = Countly || {};
Countly.q = Countly.q || [];

//provide countly initialization parameters
Countly.app_key = '221d65439a90e23ec6463648a20c72e70263ed45';
Countly.url = 'http://countly.wolfogre.com'; //or none for default countly cloud

Countly.q.push(['track_sessions']);
Countly.q.push(['track_pageview']);
Countly.q.push(['track_clicks']);
Countly.q.push(['track_errors']);
Countly.q.push(['track_links']);
Countly.q.push(['track_forms']);

//load countly script asynchronously
(function() {
    var cly = document.createElement('script'); cly.type = 'text/javascript';
    cly.async = true;
    //enter url of script here
    cly.src = 'http://countly.wolfogre.com/sdk/web/countly.min.js';
    cly.onload = function(){Countly.init()};
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(cly, s);
})();