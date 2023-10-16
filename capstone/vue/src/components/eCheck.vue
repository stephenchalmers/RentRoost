<template>
  <div id="eCheck-container">
      <div id="eCheck-form-container">
         <h4>eCheck</h4>
         <form id="eCheck-form" @submit.prevent="requestFormSubmit">
             <label for="date">Current Date:</label>
             <input type="date" id="date">
             <label for="amount">eCheck Amount:</label>
             <input type="number" id="amount">
             <label for="print-name">Print Name:</label>
             <input type="text" id="print-name">
             <input type="submit">
         </form>
         
      </div>
    

  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "Hello from Vue component",
      name: "eCheck",
      methods: {
          requestFormSubmit(e) {
              e.preventDefault();
          }
      }
    };
  }
};
</script>

<style>
#eCheck-container {
    border-top: solid 10px #ff0000;
    width: 100%;
    border-radius: 3px;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    padding-bottom: 50px;
            box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}
#eCheck-form-container {
    margin-top: 40px;
    width: 80%;
    display: flex;
    flex-direction: column;}

h4 {
    font-weight: 200;
}

#eCheck-form {
    display: flex;
    justify-content: space-between;
    width: 100%;
    flex-wrap: wrap;
}

textarea {
    border: 0;
    outline:0;
        border-radius: 3px;
    height: 300px;
    resize: none;
}


input[type=submit] {
    background-color: #ff0000;
    border: none;
    box-shadow: none;
    border-radius: 3px;
    color: white;
    font-weight: 300;
    margin: 0px;
    margin-top: 30px;
    width: 200px;
    padding: 10px 0;
    outline:0;
    
}

input[type=date] {
    width: 30%;
    
}

input[type=number] {
    width: 30%;
    margin-right: 100px
    
}

input[type=submit]:hover {
        box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

.tenant-button {
    background-color: #ff0000;
    box-shadow: none;
    border-radius: 3px;
    color: white;
    font-weight: 300;
    margin: 0px;
    margin-top: 20px;
    
    
}

.tenant-button:hover {
    color: white;
}

</style>