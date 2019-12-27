import Vue from 'vue'
import Router from 'vue-router'
// import Home from '@/components/Home.vue'
import Join from '@/components/member/Join.vue'
import Login from '@/components/member/Login.vue'
import Articles from '@/components/brd/Articles.vue'
import ArticleRemoval from '@/components/brd/ArticleRemoval.vue'
import ArticleFindOne from '@/components/brd/ArticleFindOne.vue'
import ArticleEdit from '@/components/brd/ArticleEdit.vue'
import ArticleAdd from '@/components/brd/ArticleAdd.vue'
import Mypage from '@/components/member/Mypage.vue'
import MypageUpdate from '@/components/member/MypageUpdate.vue'
import Admin from '@/components/member/Admin.vue'
import StudentList from '@/components/students/StudentList.vue'
import StudentAdd from '@/components/students/StudentAdd.vue'
import StudentEdit from '@/components/students/StudentEdit.vue'
import StudentFindOne from '@/components/students/StudentFindOne.vue'
import StudentFindSome from '@/components/students/StudentFindSome.vue'
import StudentRemoval from '@/components/students/StudentRemoval.vue'

//@ 이는 src까지의 의미다 !!
Vue.use(Router)
//루트가 home이 하나 있어야 된다
export default new Router({
	mode : 'history',
	routes : [
		// {path : '/', name: '/home', component: Home},
		{path : '/join', name: '/join', component: Join},
		{path : '/login', name : 'login', component:Login},
		{path : '/articles', name : 'articles', component: Articles},
		{path : '/articleRemove', name : 'articleRemove', component : ArticleRemoval},
		{path : '/articleFindOne', name : 'articleFindOne', component: ArticleFindOne},
		{path : '/articleEdit', name : 'articleEdit', component: ArticleEdit},
		{path : '/articleAdd', name : 'articleAdd', component: ArticleAdd},
		{path : '/mypage', name : 'mypage',component : Mypage},
		{path : '/mypageUpdate',name:'mypageUpdate',component : MypageUpdate},
		{path : '/admin',name:'admin',component : Admin},
		{path :'/studentList',name : 'studentList',component : StudentList},
		{path :'/studentAdd',name : 'studentAdd',component : StudentAdd},
		{path :'/studentEdit',name : 'studentEdit',component : StudentEdit},
		{path :'/studentFindOne',name : 'studentFindOne',component : StudentFindOne},
		{path :'/studentFindSome',name : 'studentFindSome',component : StudentFindSome},
		{path :'/studentRemove',name : 'studentRemove',component : StudentRemoval}
	]
})
