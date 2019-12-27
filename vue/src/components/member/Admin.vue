<template #content="content">
<student-list></student-list>
</template>
<script>
import {store} from '@/store'
import StudentList from '@/components/students/StudentList.vue'
export default{
  components : {StudentList},
	data(){
		return {
			person : store.state.person,
			sidebars : [
				{menu:"학생등록",link:"/studentAdd"},
						{menu:"학생목록",link:"/students"},
						{menu:"학생정보수정",link:"/studentEdit"},
						{menu:"학생정보삭제",link:"/studentRemove"},
            {menu:"학생검색",link:"/studentFindOne"}],
      authCheck : true
		}
	}
}
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