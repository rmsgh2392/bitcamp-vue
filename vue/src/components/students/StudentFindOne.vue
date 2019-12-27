<template>
<div>
	<div class="login-form">    
    <form >
    	<h4 class="modal-title">학번 검색</h4>
        <div class="form-group">
            <input v-model="searchHak"   type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <input type="submit" class="btn btn-primary btn-block btn-lg" value="학번이뭐니" @click.prevent="find">              
    </form>			
	<h2>학생 조건 검색 결과</h2>
	<table class="table"><tr>
	<th>No.</th><th>아이디</th><th>비번</th><th>이름</th><th>생년월일</th>
	<th>성별</th><th>학년</th><th>반</th><th>점수</th><th>역할</th>
	</tr>
	<tr v-for="(j, i) of list" :key="j.id">
	<td>{{i+1}}</td>
	<td>{{j.userid}}</td>
	<td>{{j.passwd}}</td>
	<td>{{j.name}}</td>
	<td>{{j.birthday}}</td>
	<td>{{j.male}}</td>
	<td>{{j.hak}}</td>
	<td>{{j.ban}}</td>
	<td>{{j.score}}</td>
	<td>{{j.role}}</td>
	</tr>
	</table>
</div>
</div>
</template>
<script>
import axios from 'axios'
export default {
	data(){
		return{
			context : 'http://localhost:8080/',
			searchHak : '',
			list : []
		}
	},
	methods : {
		find(){
		axios
		.get(`${this.context}/students/${this.searchHak}`)
		.then(res=>{
			this.list = res.data
			alert(`회원수 : ${res.data.length}`)
		})
		.catch(()=>{
			alert('axios실패')
		})
		}
	}
}
</script>
<style scoped>
 body {
    color: #999;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}
.form-control {
	box-shadow: none;
	border-color: #ddd;
}
.form-control:focus {
	border-color: #4aba70; 
}
.login-form {
    width: 350px;
	margin: 0 auto;
	padding: 30px 0;
}
.login-form form {
    color: #434343;
	border-radius: 1px;
    margin-bottom: 15px;
    background: #fff;
	border: 1px solid #f3f3f3;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
}
.login-form h4 {
	text-align: center;
	font-size: 22px;
    margin-bottom: 20px;
}
.login-form .avatar {
    color: #fff;
	margin: 0 auto 30px;
    text-align: center;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	z-index: 9;
	background: #4aba70;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}
.login-form .avatar i {
    font-size: 62px;
}
.login-form .form-group {
    margin-bottom: 20px;
}
.login-form .form-control, .login-form .btn {
	min-height: 40px;
	border-radius: 2px; 
    transition: all 0.5s;
}
.login-form .close {
    position: absolute;
	top: 15px;
	right: 15px;
}
.login-form .btn {
	background: #4aba70;
	border: none;
	line-height: normal;
}
.login-form .btn:hover, .login-form .btn:focus {
	background: #42ae68;
}
.login-form .checkbox-inline {
    float: left;
}
.login-form input[type="checkbox"] {
    margin-top: 2px;
}
.login-form .forgot-link {
    float: right;
}
.login-form .small {
    font-size: 13px;
}
.login-form a {
    color: #4aba70;
}
.table{border : 1px solid black}
.table tr{border : 1px solid black}
.table tr th{border : 1px solid black}
.table tr td{border : 1px solid black}
</style>