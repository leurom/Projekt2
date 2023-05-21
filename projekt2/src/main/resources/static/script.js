function classify_image(event, input) {
  var file = input.files[0];
  var reader = new FileReader();

  reader.onload = function(e) {
      var imagePreview = document.getElementById('preview');
      imagePreview.src = e.target.result;
  };

  reader.readAsDataURL(file);

  var form = new FormData();
  form.append('file', file);

  $.ajax({
      url: '/upload',
      type: 'POST',
      data: form,
      processData: false,
      contentType: false,
      success: function(response) {
          var classifications = response.classifications;

          var answerDiv = document.getElementById('answer');
          answerDiv.innerHTML = '<ul>';
          classifications.forEach(function(classification) {
              var className = classification.className;
              var probability = classification.probability.toFixed(2);
              answerDiv.innerHTML += '<li>' + className + ': ' + probability + '</li>';
          });
          answerDiv.innerHTML += '</ul>';

          var answerPartDiv = document.getElementById('answerPart');
          answerPartDiv.style.visibility = 'visible';
      },
      error: function(xhr, status, error) {
          console.log('Error occurred during image upload:', error);
      }
  });
}
