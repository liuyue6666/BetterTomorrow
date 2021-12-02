<template>
  <div class="hello">
    <h1 id = "a">{{msg}}</h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: '做一束可以照进彼此世界的光'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
.hello {
  /* margin: 0,100px; */
  padding: 0px;
  width: 100%;
  height: 100%;
  background: url("../assets/images/大背景.png");
  background-size: cover;
  overflow: hidden;
}
#a{
  padding-left: 100px;
  padding-top: 40px;
}
</style>
