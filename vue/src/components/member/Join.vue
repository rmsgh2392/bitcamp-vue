<template>
<div>
  <div class="signup-form">
    <form>
		<div class="form-header">
			<h2>Sign Up</h2>
			<p>Fill out this form to start your free trial!</p>
		</div>
        <div class="form-group">
			<label>UserId</label>
        	<input v-model="userid"  type="text" class="form-control" name="userid" required="required">
        </div>
		<div class="form-group">
			<label>Password</label>
            <input v-model="passwd"  type="password" class="form-control" name="password" required="required">
        </div>
		<div class="form-group">
			<label>UserName</label>
            <input v-model="name" type="text" class="form-control" name="UserName" required="required">
        </div>
		<div class="form-group">
			<label>birthday</label>
            <input v-model="birthday" type="text" class="form-control" name="birthday" required="required">
        </div>        
        <div class="form-group">
			<label class="checkbox-inline"><input type="checkbox" required="required"> I accept the <a href="#">Terms of Use</a> &amp; <a href="#">Privacy Policy</a></label>
		</div>
		<div>
			<input type="radio" name="student" value="student" v-model="role"/>
			<label for="student">학생</label>
			<input type="radio" name="manager" value="manager" v-model="role"/>
			<label for="manager">관리자</label>
			<input type="radio" name="teacher" value="teacher" v-model="role"/>
			<label for="teacher">선생님</label>
		</div><br>
		<div>
			<input type="radio" name="male" value="true" v-model="male"/>
			<label for="male">남자</label>
			<input type="radio" name="female" value="false" v-model="male"/>
			<label for="female">여자</label>
		</div>
		<div class="form-group">
			<button @click.prevent="join" type="submit" class="btn btn-primary btn-block btn-lg">Sign Up</button>
		</div>	
    </form>
	<div class="text-center small">Already have an account? <a href="#">Login here</a></div>
</div>
</div>
</template>
<script>
import axios from 'axios'
export default{
  data(){
    return {
			context : 'http://localhost:8080/',
			userid : '',
			passwd : '',
			name : '',
			birthday : '',
			role : '',
			male : ''
    }
  },
  methods : {
    join(){
        alert(`아이디 :${this.userid} 비번 :${this.passwd} 주소 :${this.name}`)
        axios
				.post(`${this.context}/join`,
							{userid : this.userid 
							,passwd : this.passwd,
							name : this.name,
							birthday : this.birthday,
							role : this.role,
							male : this.male},
							{'authorization':'JWT fefege..',
							'Accept' : 'application/json',
							'Content-Type':'application/json'})
        .then(()=>{
						alert('회원가입 성공')
						this.$router.push({path : '/login'})
        })
        .catch(()=>{
            alert('axios실패')
        })
    }
  }
}
</script>
<style scoped>
<style type="text/css">
	body{
		color: #999;
		background: #e2e2e2;
		font-family: 'Roboto', sans-serif;
	}
	.form-control{
		min-height: 41px;
		box-shadow: none;
		border-color: #e1e1e1;
	}
	.form-control:focus{
		border-color: #00cb82;
	}	
    .form-control, .btn{        
        border-radius: 3px;
    }
	.form-header{
		margin: -30px -30px 20px;
		padding: 30px 30px 10px;
		text-align: center;
		background: #00cb82;
		border-bottom: 1px solid #eee;
		color: #fff;
	}
	.form-header h2{
		font-size: 34px;
		font-weight: bold;
        margin: 0 0 10px;
		font-family: 'Pacifico', sans-serif;
    }
	.form-header p{
		margin: 20px 0 15px;
		font-size: 17px;
		line-height: normal;
		font-family: 'Courgette', sans-serif;
	}
    .signup-form{
		width: 390px;
		margin: 0 auto;	
		padding: 30px 0;	
	}
    .signup-form form{
		color: #999;
		border-radius: 3px;
    	margin-bottom: 15px;
        background: #f0f0f0;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
	.signup-form .form-group{
		margin-bottom: 20px;
	}		
	.signup-form label{
		font-weight: normal;
		font-size: 13px;
	}
    .signup-form input[type="checkbox"]{
		margin-top: 2px;
	}
    .signup-form .btn{        
        font-size: 16px;
        font-weight: bold;
		background: #00cb82;
		border: none;
		min-width: 200px;
    }
	.signup-form .btn:hover, .signup-form .btn:focus{
		background: #00b073 !important;
        outline: none;
	}
    .signup-form a{
		color: #00cb82;		
	}
    .signup-form a:hover{
		text-decoration: underline;
	}
</style>