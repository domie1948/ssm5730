import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import tousufankui from '@/views/modules/tousufankui/list'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import cheweixinxi from '@/views/modules/cheweixinxi/list'
    import yezhu from '@/views/modules/yezhu/list'
    import yiqingshuju from '@/views/modules/yiqingshuju/list'
    import fangkedengji from '@/views/modules/fangkedengji/list'
    import yiqingshangbao from '@/views/modules/yiqingshangbao/list'
    import chepaihaogenghuan from '@/views/modules/chepaihaogenghuan/list'
    import hesuanjiancebaogao from '@/views/modules/hesuanjiancebaogao/list'
    import feiyongjiaona from '@/views/modules/feiyongjiaona/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
          ,{
	path: '/tousufankui',
        name: '投诉反馈',
        component: tousufankui
      }
          ,{
	path: '/forum',
        name: '小区论坛',
        component: forum
      }
          ,{
	path: '/news',
        name: '物业公告',
        component: news
      }
          ,{
	path: '/cheweixinxi',
        name: '车位信息',
        component: cheweixinxi
      }
          ,{
	path: '/yezhu',
        name: '业主',
        component: yezhu
      }
          ,{
	path: '/yiqingshuju',
        name: '疫情数据',
        component: yiqingshuju
      }
          ,{
	path: '/fangkedengji',
        name: '访客登记',
        component: fangkedengji
      }
          ,{
	path: '/yiqingshangbao',
        name: '疫情上报',
        component: yiqingshangbao
      }
          ,{
	path: '/chepaihaogenghuan',
        name: '车牌号更换',
        component: chepaihaogenghuan
      }
          ,{
	path: '/hesuanjiancebaogao',
        name: '核酸检测报告',
        component: hesuanjiancebaogao
      }
          ,{
	path: '/feiyongjiaona',
        name: '费用缴纳',
        component: feiyongjiaona
      }
          ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
        ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
