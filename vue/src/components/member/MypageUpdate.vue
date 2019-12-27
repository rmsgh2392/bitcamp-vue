<template>
  <div class="back">
     <div align = "center"><h1><input type="text" v-model="person.name"/>님의 Mypage</h1></div>
      <div class="sub">
        <div class="pull-left rt size" >
           <fieldset style=" margin-top: 1%; height: 31.5%;border: 2px solid black;">
             <legend><h3>비밀번호 변경</h3></legend>
                <input type="text" name="pwd" size="20" placeholder="기존 비밀번호 입력" v-model="person.passwd"  style="float: none; width: 70%;">
                <button @click.prevent="update" style="height: 38%; width: 20%; float: right;">수정</button><br/><br/>
           </fieldset>
           <fieldset style="margin-top: 1%; height: 60%;border: 2px solid black;">
              <legend><h3>개인정보 변경</h3></legend>
                <input type="text" name="pwd" size="20" placeholder="변경할 학년  입력" v-model="person.hak" style="float: none;width: 70%;">학년
                <input type="text" name="pwd" size="20" placeholder="변경할 반 입력" v-model="person.ban"  style="float: none;width: 70%;">반
                <input type="text" name="pwd" size="20" placeholder="변경할 성적 입력" v-model="person.score"   style="float: none;width: 70%;">점
                <br/><br/>
                <button style="height: 20%; width: 70%; float: none;" @click.prevent="modify">수정</button>
           </fieldset>
        </div>
        <div class="pull-right size" >
            <fieldset style="height: 49%;border: 2px solid black;">
                <legend><h3>정보보기</h3></legend>
                <a href="#" ><h3>예약리스트 보기</h3></a>
                <a href="#" ><h3 align = "center">내업체 보기</h3></a>
                <a href="#" ><h3 align = "center">업체 등록 하기</h3></a>
            </fieldset>
            <fieldset style="margin-top: 1%; height: 47.5%; border: 2px solid black;">
              <legend><h3>등록업체 삭제</h3></legend>
              <select name="pat" id="pattype" style="height: 21.5px; vertical-align:middle;">
               <option value="LargeDog">업체1</option>
               <option value="LargeDog">업체2</option>
               <option value="SmallDog">업체3</option>
               <input type="text" placeholder="직접입력" style="float: none; width: 70%;">
              </select>
                <button style="width: 20%; float: right;">등록</button><br/><br/>
            </fieldset>
        </div>
      </div>
    </div>
</template>
<script>
import {store} from '../../store'
//{store} -> 객체 destructuring
import axios from 'axios'
export default {
	data(){
		return{
      context : 'http://localhost:8080/',
      person : store.state.person
		}
	},
  methods : {
      modify(){
      axios
      .put(`${this.context}/modify`,this.person)
      .then(res=>{
        this.person = res.data.data
        if(res.data.msg ==='success'){
          alert('수정완료')
          this.$router.push({path : '/mypage'})
        }else{
          alert('수정실패')
        }
      })
      .catch(()=>{
        alert('axios실패')
      })
      }
  }

	
}
//Object.keys(store.state).map(i=>{
//store.state[i] = ''
</script>
<style scoped>
.back {width: 700px; margin: 0 ;}
.sub {width: 100%; height: 600px; margin: 0 auto; text-align: center;}
.pull-left {float: left;}
.pull-right {float: right;}
.top {margin-top: 1%;}
.rt {margin-right: 1%;}
.size {width: 49.5%; height: 100%;}
</style>