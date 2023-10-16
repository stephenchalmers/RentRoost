<template>
  <div>
  
  <form id="imageForm">
    <input id="imageInput" type="file" accept="image/*">
    <button type="submit">Upload</button>
  </form>

  </div>
</template>

<script>

const imageForm = document.querySelector("#imageForm")
const imageInput = document.querySelector("#imageInput")

imageForm.addEventListener("submit", async event => {
  event.preventDefault()
  const file = imageInput.files[0]

  // get secure url from our server
  const { url } = await fetch("/s3Url").then(res => res.json())
  console.log(url)

  // post the image direclty to the s3 bucket
  await fetch(url, {
    method: "PUT",
    headers: {
      "Content-Type": "multipart/form-data"
    },
    body: file
  })

  const imageUrl = url.split('?')[0]
  console.log(imageUrl)

  // post requst to my server to store any extra data
    
  const img = document.createElement("img")
  img.src = imageUrl
  document.body.appendChild(img)
})

</script>

<style scoped>
form  {
  display: flex;
  flex-direction: column;
  width: 300px;
  margin: auto;
}

form > * {
  margin: 5px 0;
  box-sizing: border-box;
}
</style>