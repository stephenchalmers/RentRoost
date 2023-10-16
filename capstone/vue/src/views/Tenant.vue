<template>
  <div class="tenant">
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
              <router-link class="nav-link" to="/register">Register</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/login"> Log in</router-link>
            </li>
            
          </ul>
        </div>
      </div>
    </nav>
    <!-- Nav bar ABOVE. 

    Balance,Maintenance Request, eCheck BELOW -->
    <div id="top-row">
      <div class="input-group">
        <balance-information />
        <maintenance-request-form />
      </div>
      <div class="submit-group">
        <br>
        <e-check />
      </div>
    </div>
  </div>
</template>

<script>
import BalanceInformation from '../components/BalanceInformation.vue';
import ECheck from '../components/eCheck.vue';
import MaintenanceRequestForm from '../components/MaintenanceRequestForm.vue';
export default {
  components: { BalanceInformation, MaintenanceRequestForm, ECheck },
  name: "tenant"
};



</script>

<style>
#top-row {
  padding-top: 100px;
}
.tenant {
      display: flex;
    justify-content: center;
    width: 100%
}

  .input-group {
    display: flex;
    justify-content: space-between;
  }

 
</style>
