
<template>

    
    <div class ="employee">

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
      
        <list-of-tenants-table/>
        <maintenance-request-table/>
        <!-- <account-creator-form/> -->
    </div>
</template>

<script>
// import AccountCreatorForm from '../components/AccountCreatorForm.vue'
import ListOfTenantsTable from '../components/ListOfTenantsTable.vue';
import MaintenanceRequestTable from '../components/MaintenanceRequestTable.vue';
export default {
  components: {ListOfTenantsTable, MaintenanceRequestTable},
  name: "employee"
};
</script>

<style>

</style>
