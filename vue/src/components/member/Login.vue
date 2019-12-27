<template>
<div>
	<div class="login-form">    
    <form >
		<div class="avatar"></div>
    	<h4 class="modal-title">Welcome New World</h4>
        <div class="form-group">
            <input v-model="userid"   type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input v-model="passwd"  type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group small clearfix">
            <label class="checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="forgot-link">Forgot Password?</a>
        </div> 
        <input type="submit" class="btn btn-primary btn-block btn-lg" value="Login" @click.prevent="login">              
    </form>			
    <div class="text-center small">Don't have an account?<router-link to="/join">Sign up</router-link></div>
</div>
</div>
</template>
<script>
import axios from 'axios'
import {store} from '../../store'
export default{
	data(){
		return {
			context : 'http://localhost:8080/',
			userid : 'hong',
			passwd : '1111'
		}
	},
	methods : {
		login(){
			alert(`${this.userid} ${this.passwd}`)
			axios
			.post(`${this.context}/login`,{userid : this.userid, passwd : this.passwd},
			{'authorization':'JWT fefege..',
			 'Accept' : 'application/json',
			 'Content-Type':'application/json'})
			.then(res=>{
			if(res.data.msg === 'success'){
				alert(`로그인 성공 ${res.data.person.userid} ${res.data.person.passwd}`)
				store.state.person = res.data.person
				store.state.authCheck = true

				if(store.state.person.role !== 'student'){
					store.state.sidebar = 'managerSidebar'
					store.state.headerMessage = '난 관리자'
					this.$router.push({path : '/admin'})
				}else{
					store.state.sidebar = 'studentSidebar'
					store.state.headerMessage = '난 학생'
					this.$router.push({path : '/mypage'})
				}
			}else{
				alert('로그인 실패')
				this.$router.push({path : '/login'})
			}
			})
			.catch(()=>{
				alert('axios 실패')
			})
		}
	},
	computed : {
		loginCheck(){
			return store.state.authCheck
		},
		sidebarCheck(){
			return store.state.sidebar
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
</style>