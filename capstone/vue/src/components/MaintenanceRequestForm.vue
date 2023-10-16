<template>
  <div id="main-container">
    <div id="request-form-container">
      <h4>Maintenance Request</h4>
      <form id="maintenance-request-form" @submit.prevent="requestFormSubmit">
        <textarea
          v-model="formEntry.maintenanceRequest"
          id="maintenance-form-text-area"
          name="form-text-area"
          rows="4"
          cols="50"
        >
        </textarea>
        <input type="submit" />
      </form>
    </div>
  </div>
</template>

<script>
import propertyService from "../services/PropertyService";

export default {
  data() {
    return {
      message: "Hello from Vue component",
      name: "maintenanceRequestForm",
      formEntry: {
        maintenanceRequest: "Test"
      },
    };
  },
  methods: {
    requestFormSubmit() {
      const newRequest = {
        maintenanceRequest: this.formEntry.maintenanceRequest
      };
      console.log(newRequest)
      propertyService
        .addMaintenanceRequest(newRequest)
        .then((response) => {
          if (response === 201) {
            console.log("success");
          }
        })
        .catch((error) => {
          const response = error.response;
          if (response.status == 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>

<style scoped>
#main-container {
  border-top: solid 10px #ff0000;
  width: 45%;
  border-radius: 3px;
  background-color: #f5f5f5;
  display: flex;
  justify-content: center;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  padding-bottom: 50px;
}
#request-form-container {
  margin-top: 40px;
  width: 80%;
  display: flex;
  flex-direction: column;
}

h4 {
  font-weight: 200;
}

#maintenance-request-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 100%;
}

textarea {
  border: 0;
  outline: 0;
  border-radius: 3px;
  height: 300px;
  resize: none;
}
input[type="submit"] {
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
  outline: 0;
}

input[type="submit"]:hover {
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
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