 window.onload=function(){
var form = document.getElementById("form")


document.getElementById("form").addEventListener('submit', function(event){
    event.preventDefault();
  const Data={
 firstName: document.getElementById('firstName').value,
 lastName: document.getElementById('lastName').value,
 streetAddress: document.getElementById('streetAddress').value,
 mailingAddress: document.getElementById('mailingAddress').value,
 city: document.getElementById('city').value,
 state: document.getElementById('state').value,
 country: document.getElementById('country').value,
 zip: document.getElementById('zipCode').value,
 email: document.getElementById('email').value
}
   sendHTTPRequest('POST','http://demoapp.hopto.org:80/HorseRacing-0.0.1-SNAPSHOT/register/register', Data).then(responseData => {
    console.log(responseData).catch(err => { 
        console.log(err)}
    )});


//const sendHTTPRequest = (method, url, data) => {
  
function sendHTTPRequest(method, url,data){
fetch(url,  {
    method: 'POST',
    body: JSON.stringify(data),
    headers: data ? {'Content-Type' : 'application/json'} : {}
}).then(res => {
    if(response.status >= 400) {
        return response.json().then(errResData => {
            const error = new Error("Something is borked");
            error.data = errResData;
            throw error;
        })}
      else {
          return res.json();
     }})
    }





const request = () => {
    sendHTTPRequest('POST','http://demoapp.hopto.org:80/HorseRacing-0.0.1-SNAPSHOT/register/register', Data).then(responseData => {
    console.log(responseData).catch(err => { 
        console.log(err)}
    )});
}



})} 

    /*

// Variable to hold request
var request;


// Bind to the submit event of our form
$("#form").submit(function(event){

    // Prevent default posting of form - put here to work in case of errors
    event.preventDefault();

    // Abort any pending request
    if (request) {
        request.abort();
    }
    // setup some local variables
    var $form = $(this);

    // Let's select and cache all the fields
    var $inputs = $form.find("input, select, button, textarea");

    // Serialize the data in the form
    var serializedData = $form.serialize();

    // Let's disable the inputs for the duration of the Ajax request.
    // Note: we disable elements AFTER the form data has been serialized.
    // Disabled form elements will not be serialized.
    $inputs.prop("disabled", true);

    // Fire off the request to /form.php
    request = $.ajax({
        url: "http://demoapp.hopto.org:80/HorseRacing-0.0.1-SNAPSHOT/register/register",
        type: "post",
        data: serializedData
    });

    // Callback handler that will be called on success
    request.done(function (response, textStatus, jqXHR){
        // Log a message to the console
        console.log("Hooray, it worked!");
    });

    // Callback handler that will be called on failure
    request.fail(function (jqXHR, textStatus, errorThrown){
        // Log the error to the console
        console.error(
            "The following error occurred: "+
            textStatus, errorThrown
        );
    });

    // Callback handler that will be called regardless
    // if the request failed or succeeded
    request.always(function () {
        // Reenable the inputs
        $inputs.prop("disabled", false);
    });

});*/