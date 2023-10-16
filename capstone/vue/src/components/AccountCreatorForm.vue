<template>
  <div>
    <form>
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="firstname" class="sr-only">First name</label>
      <input
        type="text"
        id="firstname"
        class="form-control"
        placeholder="Firstname"
        v-model="user.firstname"
        required
        style="margin-bottom: 10px"
        autofocus
      />
      <label for="lastname" class="sr-only">Last name</label>
      <input
        type="text"
        id="lastname"
        class="form-control"
        placeholder="Lastname"
        v-model="user.lastname"
        required
        style="margin-bottom: 10px"
        autofocus
      />

      <label for="email" class="sr-only">Email</label>
      <input
        type="text"
        id="email"
        class="form-control"
        placeholder="Email"
        v-model="user.email"
        required
        style="margin-bottom: 10px"
        autofocus
      />

      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        style="margin-bottom: 10px"
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
        style="margin-bottom: 20px"
      />

      <label for="role" class="sr-only">Role</label>
      <select id="role" v-model="user.role">
        <option value="Tenant">Tenant</option>
        <option value="Landlord">Landlord</option>
        <option value="Employee">Employee</option>
      </select>

      <router-link :to="{ name: 'login' }">Have an account? </router-link>

      <button style="margin: 20px" class="reg" type="submit">
        Join Roost!
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";
export default {
  name: "AccountCreatorForm",
  data() {
    return {
      user: {
        firstname: "",
        lastname: "",
        email: "",
        username: "",
        password: "",
        confirmPassword: "",
        role: "",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    async register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },
};
</script>

<style scoped>
table {
  width: 70%;
  text-align: left;
  border-collapse: collapse;
  box-shadow: rgba(0, 0, 0, 0.07) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  font-size: 16px;
  background-color: #fafafa;
  border-radius: 3px;
  border-top: solid 10px #ff0000;
}

th {
  padding-top: 40px;
  padding: 10px;
  font-weight: bold;
  font-size: 18px;
  border-bottom: 1px solid #f2f2f2;
}

td {
  padding: 10px;
  border-bottom: 1px solid #f2f2f2;
}

td button {
  background-color: #ff0000;
  box-shadow: none;
  border-radius: 3px;
  color: white;
  font-weight: 300;
  margin-top: 0px;
  padding: 10px 0;
  outline: 0;
}

td button:hover {
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

select {
  background-color: #f5f5f5;
  border: none;
  box-shadow: none;
  border-radius: 3px;
  color: #000;
  font-weight: 300;
  margin: 0px;
  padding: 10px 0;
  outline: 0;
  width: 100%}
</style>