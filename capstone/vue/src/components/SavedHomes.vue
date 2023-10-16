<template>
  <div class="main-container">
    <div id="saved-homes-container">
      <h1>Saved Homes</h1>
      <div id="dropdown-container">
        <div class="dropdown">
          <h3>5 saved homes</h3>
          <button
            class="btn btn-Danger dropdown-toggle"
            type="button"
            id="dropdownMenuButton"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Showing All
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">For Rent</a>
            <a class="dropdown-item" href="#">Recently Sold</a>
            <a class="dropdown-item" href="#">Off-Market</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "saved-homes",
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
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  padding-bottom: 50px;
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px,
    rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
}

.dropdown-container {
  background-color: white;
  width: 60%;
  display: flex;
  justify-content: flex-end;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  padding-bottom: 50px;
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px;
}
</style>
