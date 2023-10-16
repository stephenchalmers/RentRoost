<template>
  <div class="user">
    <nav class="navbar navbar-expand-md navbar-light fixed-top">
      <div class="container-fluid">
        <a href="http://localhost:8080/" class="navbar-brand"
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
          <ul class="navbar-nav mr-auto">
            <li><drop-down-menu /></li>
            <li class="nav-item">
              <router-link class="nav-link" to="/account">Account</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/logout"> Log out</router-link>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <!--  -->
    <div class="OG-BOX">
      <div class="AC-T">
        <h1 font-family="serif" class="Title-text">Account Options</h1>
      </div>

      <div class="gQu" id="Fifth">
        <div class="Four">
          <div class="rec-container1">
            <div class="rec-container2">
              <a href="../tenant">
                <div class="flex-div">
                  <div display="flex" class="Profile-box">
                    <div display="flex" class="inner-probox">
                      <div display="inline-flex" style="width: 44px">
                        <svg
                          width="24"
                          height="24"
                          viewBox="0 0 24 24"
                          stroke="#000000"
                          stroke-width="2"
                          stroke-linecap="round"
                          stroke-linejoin="round"
                          fill="currentColor"
                        >
                          <circle cx="12" cy="8" r="5" />
                          <path d="M3,21 h18 C 21,12 3,12 3,21" />
                        </svg>
                      </div>
                    </div>
                    <div display="flex" class="Pro-text">
                      <strong class="strong"> Account info</strong>
                      <span>Update your account info </span>
                    </div>
                  </div>
                  <div class="arrow1">
                    <svg
                      class="chevron"
                      viewbox="0 0 32 32"
                      aria-hidden="true"
                      focusable="false"
                      role="img"
                    >
                      <title>Chevron Right</title>
                      <path
                        stroke="currentColor"
                        d="M29.41 8.59a2 2 0 00-2.83 0L16 19.17 5.41 8.59a2 2 0 00-2.83 2.83l12 12a2 2 0 002.82 0l12-12a2 2 0 00.01-2.83z"
                      ></path>
                    </svg>
                  </div>
                </div>
              </a>
            </div>
          </div>
        </div>

        <!--  -->
        <div class="gQu" id="Fifth">
          <div class="Four">
            <div class="rec-container1">
              <div class="rec-container2">
                <a href="../tenant">
                  <div class="flex-div">
                    <div display="flex" class="Profile-box">
                      <div display="flex" class="inner-probox">
                        <div display="inline-flex" style="width: 44px">
                          <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="44"
                            height="50"
                            fill="limegreen"
                            class="bi bi-cash"
                            viewBox="0 0 16 16"
                          >
                            <path d="M8 10a2 2 0 1 0 0-4 2 2 0 0 0 0 4z" />
                            <path
                              d="M0 4a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H1a1 1 0 0 1-1-1V4zm3 0a2 2 0 0 1-2 2v4a2 2 0 0 1 2 2h10a2 2 0 0 1 2-2V6a2 2 0 0 1-2-2H3z"
                            />
                          </svg>
                        </div>
                      </div>
                      <div display="flex" class="Pro-text">
                        <strong class="strong"> Pay Rent or Send Maintenance Ticket</strong>
                        <span>
                          Pay any rent due or send Maintainence Request
                        </span>
                      </div>
                    </div>
                    <div class="arrow1">
                      <svg
                        class="chevron"
                        viewbox="0 0 32 32"
                        aria-hidden="true"
                        focusable="false"
                        role="img"
                      >
                        <title>Go</title>
                        <path
                          stroke="none"
                          d="M29.41 8.59a2 2 0 00-2.83 0L16 19.17 5.41 8.59a2 2 0 00-2.83 2.83l12 12a2 2 0 002.82 0l12-12a2 2 0 00.01-2.83z"
                        ></path>
                      </svg>
                    </div>
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>
        <!--  -->
        <!-- <div class="gQu" id="Fifth">
          <div class="Four">
            <div class="rec-container1">
              <div class="rec-container2">
                <a href="../myProfile">
                  <div class="flex-div">
                    <div display="flex" class="Profile-box">
                      <div display="flex" class="inner-probox">
                        <div display="inline-flex" style="width: 44px">
                          <svg
                            style="color: #f3da35"
                            xmlns="http://www.w3.org/2000/svg"
                            width="44"
                            height="55"
                            fill="currentColor"
                            class="bi bi-egg-fill"
                            viewBox="0 0 16 16"
                          >
                            <path
                              d="M14 10a6 6 0 0 1-12 0C2 5.686 5 0 8 0s6 5.686 6 10z"
                              fill="#f3da35"
                            ></path>
                          </svg>
                        </div>
                      </div>
                      <div display="flex" class="Pro-text">
                        <strong class="strong"> Saved Properties </strong>
                        <span> See Properties You saved </span>
                      </div>
                    </div>
                    <div class="arrow1">
                      <svg
                        class="chevron"
                        viewbox="0 0 32 32"
                        aria-hidden="true"
                        focusable="false"
                        role="img"
                      >
                        <title>Chevron Right</title>
                        <path
                          stroke="none"
                          d="M29.41 8.59a2 2 0 00-2.83 0L16 19.17 5.41 8.59a2 2 0 00-2.83 2.83l12 12a2 2 0 002.82 0l12-12a2 2 0 00.01-2.83z"
                        ></path>
                      </svg>
                    </div>
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div> -->

        <!-- <div> 
        <h4>Your Current Balance</h4>
        <h1>${{ balance }}</h1>
        <button class="tenant-button">Pay Balance</button>
        <i class="fa-solid fa-chevron-right"></i>
      </div>-->
      </div>

      <!-- <div v-bind="like in likes" @click="toggleLike(like)"> -->

      <!-- <h2>{{ like.firstname }} {{ like.lastname }}</h2> -->
      <!-- <p>{{ like.email }}</p> -->
      <!-- </div> -->
    </div>
  </div>
</template>
    


<script>
export default {
  name: "user",
  data() {
    return {
      likes: [],
    };
  },

  methods: {
    toggleLike(like) {
      like.classList.toggle("like-no");
      like.classList.toggle("like-yes");
      if (like.classList.contains("like-yes")) {
        console.log(" Saving Favorite");
        this.getFavoriteData(like);
      } else {
        console.log(" Removing Favorite");
        this.getFavoriteData(like);
      }
    },
    getFavoriteData(like) {
      const img = like.querySelector("img").src;
      const name = like.querySelector("h2").textContent;
      const email = like.querySelector("p").textContent;
      const [firstname, lastname] = name.split(" ");
      const faveObj = { img, firstname, lastname, email };

      console.log(faveObj);
    },
  },
};
</script>


<style>
@import url("https://fonts.googleleapis.com/css?family=Fira+Sans:400,500,600,700,800");

#header-container {
  width: 100vw;
  height: 10vh;
  background-color: red;
}
.AC-T {
  margin: 0px 16px 24px;
  padding-top: 100px;
  display: flex;
  -webkit-box-pack: justify;
  justify-content: space-between;
}
.Title-text {
  color: rgb(42, 42, 51);
  -webkit-font-smoothing: antialiased;
  text-transform: none;
  font-family: "Fira Sans", sans-serif;
  font-weight: 700;
  font-size: 36px;
  line-height: 40px;
  margin: 0px;
}
.chevron {
  transform: rotate(270deg);
  overflow: hidden;
  display: inline-block;
  vertical-align: top;
  stroke: currentcolor;
  fill: currentcolor;
  color: rgb(158, 158, 158);
  height: 32px;
  width: 32px;
}

.arrow1 {
  margin: 24px;
}
.strong a {
  cursor: pointer;
  font-weight: 300;
  text-decoration: none;
  color: #ff0000;
}

.gQu {
  width: 100%;
  background: transparent;
  /* box-shadow: 0px 14px 80px rgba(34, 35, 58, 0.2); */
}

span {
  color: rgb(42, 42, 51);
  -webkit-font-smoothing: antialiased;
  text-transform: none;
  font-family: "Fira Sans", sans-serif;
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  margin: 0px;
  display: none;
}

.strong {
  color: rgb(42, 42, 51);
  -webkit-font-smoothing: antialiased;
  text-transform: none;
  font-family: "Fira Sans", sans-serif;
  font-size: 16px;
  line-height: 24px;
  font-weight: 700;
  margin: 0px;
}

.Pro-text {
  display: flex;
  flex-direction: column;
  -webkit-box-pack: center;
  justify-content: center;
  margin: 24px;
}
.inner-probox {
  display: flex;
  flex-direction: row;
}
.Profile-box {
  display: flex;
  flex-direction: row;
  -webkit-box-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  align-items: center;
}

.flex-div {
  display: flex;
  flex-direction: row;
  -webkit-box-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  align-items: center;
  
}
.rec-container2 {
  padding: 20px;
  margin: 10px;
  background: white;
  border: 1px solid rgb(148, 148, 148);
}

.rec-container1 {
  max-width: 1280px;
  margin: auto;
}

.Four {
  background: rgba(189, 189, 189, 0);
  border: none;
  padding: 8px;
}

.Fifth {
  display: flex;
  flex-shrink: 0;

}

.OG-BOX {
  background-color: rgb(249, 249, 251);
  padding: 24px 0px;
  display: flex;
  flex-direction: column;
  height: 50vh;
  width: 100vh;
}

.saved-homes {
  display: flex;
  justify-content: center;
  width: 100%;
  background-color: rgba(211, 211, 211, 0);
}
main {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  flex-wrap: wrap;
}

article {
  max-width: 300px;
  margin: 20px 10pc 0;
  border: 1px solid #000;
  border-radius: 15px;
  box-shadow: 5px 5px 10px #333;
  position: relative;
  background-color: white;
}

img {
  display: block;
  width: 100%;
  border-radius: 10px 10px 0 0;
}

.details {
  padding: 10px;
}

.like {
  width: 48px;
  height: 48px;
  position: absolute;
  top: 2%;
  right: 2%;
}

.like-no {
  background: url("../../public/images/egg-unsave-btn.svg") no-repeat;
}

.like {
  background: url("../../public/images/egg-save-btn.svg") no-repeat;
}
</style>
