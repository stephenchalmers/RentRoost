<template>
  <div id="main-container">
      <div id="current-balance-container">
         <h4>Your Current Balance</h4>
         <h1>${{balance}}</h1>
         <button class="tenant-button" @click="payRent()">Pay Balance</button>
         <button class="tenant-button" id="autopay" >Manage Autopay Settings</button>
      </div>
    

  </div>
</template>

<script>
export default {
  data() {
    return {
      message: "Hello from Vue component",
      name: "balanceInformation",
      balance: 2800,
    };
  },
  methods: {
    payRent() {
      alert("Thank you! Your payment has been made using autopay settings.")
      this.balance = 0;
    }
  }
};
</script>

<style>
#main-container {
    border-top: solid 10px #ff0000;
    width: 45%;
    border-radius: 3px;
    background-color: #f5f5f5;
    display: flex;
    justify-content: center;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    padding-bottom: 50px;
    box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}
#current-balance-container {
    margin-top: 40px;
    width: 100%;
    display: flex;
    padding-left: 25%;
    flex-direction: column;}

h4 {
    font-weight: 200;
}
h1 {
    font-weight: 400;
    margin-top: -8px;
}

.tenant-button {
    background-color: #ff0000;
    box-shadow: none;
    border-radius: 3px;
    color: white;
    font-weight: 300;
    margin: 0px;
    margin-top: 20px;
    width: 65%;
}

#autopay {
  background-color: rgb(175, 118, 118);
}
.tenant-button:hover {
    color: white;
        box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
    width: 65%;
}

</style>