<template>
  <div id="app">
    <div class="blurredImg"></div>
    <nav class="navbar navbar-expand-md navbar-light fixed-top">
      <div class="container-fluid">
        <a href="#" class="navbar-brand"
          ><img alt="logo" src="../../public/images/logo.png"
        /></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="navbarsExampleDefault"
          label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="_collapse _navbar-collapse">
          <!-- ^^ class name changed...rename if needed -->
          <ul class="navbar-nav mr-auto">
            <!-- <li class="nav-item">
              <router-link class="nav-link" to="/user">Acocunt</router-link>
            </li> -->
            <li class="nav-item">
              <router-link class="nav-link" to="/login"> Log in</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Nav bar -->
    <!-- Registraition  -->

    <div class="auth-wrapper">
      <div class="auth-inner">
        <div id="register" class="text-center">
          <form class="form-register" @submit.prevent="register">
            <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
            <div
              class="alert alert-danger"
              role="alert"
              v-if="registrationErrors"
            >
              {{ registrationErrorMsg }}
            </div>
            <label for="firstname" class="sr-only">First name</label>
            <input
              type="text"
              id="firstname"
              class="form-control"
              placeholder="First Name"
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
              placeholder="Last Name"
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
            <label for="phone" class="sr-only">Phone</label>
            <input
              type="text"
              id="phone"
              class="form-control"
              placeholder="Phone"
              v-model="user.phone"
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

            <p>Select roles:</p>

            <div
              class="role-checkboxes"
              v-for="(role, key) in selectedRoles"
              :key="key"
            >
              <label :for="key" type="checkbox">{{ role }}</label>
              <input type="checkbox" @change="updateUser(role)" />
            </div>

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
            <router-link :to="{ name: 'login' }">Have an account? </router-link>

            <button style="margin: 20px" class="reg" type="submit">
              Join Roost!
            </button>
          </form>
        </div>
        <!-- <div class="center">
      <h1 id="captchaHeading">
        Captcha Validator Using HTML, CSS and JavaScript
      </h1>
      <div id="captchaBackground">
        <canvas id="captcha">captcha text</canvas>
        <input id="textBox" type="text" name="text" />
        <div id="buttons">
          <input id="submitButton" type="submit" />
          <button id="refreshButton" type="submit">Refresh</button>
        </div>
        <span id="output"></span>
      </div>
    </div> -->
      </div>
    </div>
    
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        firstname: "",
        lastname: "",
        email: "",
        phone: "",
        username: "",
        password: "",
        confirmPassword: "",
        role: "",
      },
      selectedRoles: ["Landlord", "Tenant", "Employee"],
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    updateUser(role) {
      // method looks for change in checkbox, finds choice, then modifies
      // the user object role property. Also makes the other checkboxes read only
      //so only one check box is clicked at a time OR just set the other checkboxes to false.
      alert(role);

      this.user.role = role;
    },
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
                path: "/login"
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


<style>
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");
body {
  background-color: #232331;
  font-family: "Roboto", sans-serif;
}

#captchaBackground {
  height: 220px;
  width: 250px;
  background-color: #2d3748;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

#captchaHeading {
  color: white;
}

#captcha {
  height: 80%;
  width: 80%;
  font-size: 30px;
  letter-spacing: 3px;
  margin: auto;
  display: block;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
}

.center {
  display: flex;
  flex-direction: column;
  align-items: center;
}

#submitButton {
  margin-top: 2em;
  margin-bottom: 2em;
  background-color: #08e5ff;
  border: 0px;
  font-weight: bold;
}

#refreshButton {
  background-color: #08e5ff;
 border: 0px;
  font-weight: bold;
}

#textBox {
  height: 25px;
}

.incorrectCaptcha {
  color: #ff0000;
}

.correctCaptcha {
  color: #7fff00;
}

* {
  box-sizing: border-box;
}
body {
  background: #ffffff !important;
  min-height: 100vh;
  display: flex;
  font-weight: 400;
  font-family: "Fira Sans", sans-serif;
}
.blurredImg {
  background-image: url(../../public/images/coupleMoving.jpg);
  filter: blur(4px);
  height: 100vh;
  width: 100vw;
  background-size: cover;
  position: fixed;
  top: 0px;
  z-index: -1;
}

h1,
h2 h3,
h4,
h5,
h6,
label,
span {
  font-weight: bold;
  font-family: "Fira Sans", sans-serif;
  color: rgba(0, 0, 0, 0.685);
}

body,
html,
#app,
.auth-wrapper {
  width: 100%;
  height: 100%;
}

.role-checkboxes {
  display: flex;
  justify-content: space-between;
}

.navbar-collapse {
  display: flex;
  justify-content: flex-end;
}
.navbar-brand {
  padding: 0;
  margin: 0;
}
.navbar-brand img {
  display: flex;
  justify-content: flex-start;
  height: 50px;
  width: 200px;
  padding: 0;
  margin: 0;
  right: 0;
}
.navbar-brand {
  text-transform: uppercase;
  color: red;
}
.navbar-light {
  display: flex;

  background-color: #ffffff;
  box-shadow: 0px 5px 5px #7f7d7e;
}
a {
  box-shadow: inset 0 0 0 0 #000000;
  color: #999999;
  padding: 0 0.25rem;
  margin: 0 -0.25rem;
  transition: color 0.3s ease-in-out, box-shadow 0.3s ease-in-out;
}
a:hover {
  box-shadow: inset 179px 0 0 0 #ff0000;
  color: white;
}

a {
  color: #ff000f;
  font-family: "Fira Sans", sans-serif;
  font-size: 20px;
  font-weight: 700;
  line-height: 1.5;
  padding-right: 10px;
  text-decoration: none;
}
.auth-wrapper {
  display: flex;
  justify-content: center;
  flex-direction: column;
  text-align: left;
}

.auth-inner {
  width: 450px;
  margin: auto;
  background: #ffffff;
  box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.2);
  padding: 40px 55px 45px 55px;
  border-radius: 15px;
  transition: all 0.3s;
}

.auth-wrapper .form-control:focus {
  border-color: #a02021;
  box-shadow: none;
}

.auth-wrapper h3 {
  text-align: center;
  margin: 0;
  line-height: 1;
  padding-bottom: 20px;
}

.custom-control-label {
  font-weight: 400;
}
.navbar-nav .nav-link {
  border-bottom: 2px solid transparent;
}

.forgot-password,
.forgot-password a {
  text-align: right;
  font-size: 13px;
  padding-top: 10px;
  color: #7f7d7e;
  margin: 0;
}

.forgot-password a {
  color: #a02021;
}
button {
  cursor: pointer;
  border: 0;
  border-radius: 4px;
  font-weight: 600;
  margin: 0 10px;
  width: 200px;
  padding: 10px 0;
  box-shadow: 0 0 20px rgba(104, 85, 224, 0.2);
  transition: 0.4s;
}

.reg {
  color: white;
  background-color: rgb(192, 192, 192);
  padding-top: 10px;
}

.log {
  color: rgb(104, 85, 224);
  background-color: rgba(255, 255, 255, 1);
  border: 1px solid rgb(255, 0, 0);
  padding: 10px;
}

button:hover {
  color: white;
  width: 200px;
  box-shadow: 0 0 20px rgba(182, 0, 0, 0);
  background-color: rgb(240, 4, 4);
}
</style>