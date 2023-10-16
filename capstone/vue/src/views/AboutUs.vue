<template>
  <div class="container">
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
   
    <div class="row">
      <div class="col-3">
        <div class="about-card-col">
          <div class="card">
            <img
              src="../../public/images/team_pics/Stephen.jpg"
              class="card-img-top"
              alt=""
            />
            <div class="card-body">
              <h5 class="card-title">STEPHEN CHALMERS</h5>
              <p class="card-text">
                Burgeoning software developer, and a skilled public speaker with
                expertise in distilling complex subjects as a media
                spokesperson. Visionary leader with exceptional communication
                and creative problem-solving skills. A Renaissance Man with a
                wide and varied experience that spans multiple fields.
              </p>
              <a
                href="https://www.linkedin.com/in/s-chalmers/"
                class="btn btn-primary"
                >LinkedIn</a
              >
            </div>
          </div>
        </div>
      </div>
      <div class="col-3">
        <div class="about-card-col">
          <div class="card">
            <img
              src="../../public/images/team_pics/Des.jpg"
              class="card-img-top"
              alt=""
            />
            <div class="card-body">
              <h5 class="card-title">DESROY FARQUHARSON</h5>
              <p class="card-text">
                As a Jamaican immigrant who grew up in the heart of NYC Desroy
                utilized his multi-cultural background to both effectively adapt
                to new environments and use communication as his main driver to
                solve professional problems. Desroy is a qualified personable
                self-driven professional with over 5+ years in both scientific
                and customer facing roles. He possesses expertise in strong
                technical communication, demo presentations, and sales cycle
                understanding. Thus combining business acumen with the
                scientific method to diagnose problems and prescribe clients
                technical resolutions.
              </p>
              <a
                href="https://www.linkedin.com/in/dfarqu/"
                class="btn btn-primary"
                >LinkedIn</a
              >
            </div>
          </div>
        </div>
      </div>
      <div class="col-3">
        <div class="about-card-col">
          <div class="card">
            <img src="../../public/images/team_pics/TomF.jpg" class="card-img-top" alt="" />
            <div class="card-body">
              <h5 class="card-title">TOM FITZPATRICK</h5>
              <p class="card-text">
                Software Developer who has spent the last decade in tech as a
                Technical Product Manager. I've loved my time in product but
                I've always been happiest close to the code where I can deep
                dive on a problem.<br /><br />
                I'm seeking a role as a Software Engineer that can leverage my
                past experience in Product Management and leading Scrum teams.
              </p>
              <a
                href="https://www.linkedin.com/in/fitzpatricktom/"
                class="btn btn-primary"
                >LinkedIn</a
              >
            </div>
          </div>
        </div>
      </div>
      <div class="col-3">
        <div class="about-card-col">
          <div class="card">
            <img src="../../public/images/team_pics/Nick.jpg" class="card-img-top" alt="" />
            <div class="card-body">
              <h5 class="card-title">NICHOLAS TSILIKOS</h5>
              <p class="card-text">
                I am a full-stack java developer that comes from a background in
                business, specifically marketing. What excites me about the
                software development field is the endless possibilities and
                creative problem solving it requires. There is nothing like
                building a new piece of software that just works, or opening up
                an old project and expanding it with new knowledge inherited.
                <br /><br />
                I've always appreciated coming up with original answers to
                issues, and working in the software industry allows me to always
                seek out fresh approaches to problem-solving. I have knowledge
                in technologies like Java, Spring Boot, Javascript, PostgreSQL,
                and web application frameworks like Vue.js thanks to my
                educational background. With the help of these abilities, I can
                approach each project with a fresh perspective and a wealth of
                information that can be used to create and enhance systems.
              </p>
              <a href="#" class="btn btn-primary">LinkedIn</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>

template {
  background-image: url("../../public/images/Red_circle.png");
  
}

.container {
  display: flex;
  align-content: space-between;
  flex-direction: column;
  
}


.row {
  width: 1000px;
  position: center;
}

.about-card-col {
  /* padding: 0 8px; */
  /* display:flex; */
  /* align-items: space-between; */
  
  box-sizing: border-box;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.card-title {
  text-align: center;
}

.card{
  width: 250px;
  padding: 10px 0px;


}

</style>

