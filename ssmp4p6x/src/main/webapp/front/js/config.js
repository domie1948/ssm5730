
var projectName = '疫情防控物业管理系统';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
	name: '我的发布',
	url: '../forum/list-my.html'
},

]


var indexNav = [

{
	name: '疫情数据',
	url: './pages/yiqingshuju/list.html'
}, 

{
	name: '小区论坛',
	url: './pages/forum/list.html'
}, 
{
	name: '物业公告',
	url: './pages/news/list.html'
},
]

var adminurl =  "http://localhost:8080/ssmp4p6x/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"业主","menuJump":"列表","tableName":"yezhu"}],"menu":"业主管理"},{"child":[{"buttons":["查看","删除","审核","修改"],"menu":"核酸检测报告","menuJump":"列表","tableName":"hesuanjiancebaogao"}],"menu":"核酸检测报告管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"疫情上报","menuJump":"列表","tableName":"yiqingshangbao"}],"menu":"疫情上报管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"访客登记","menuJump":"列表","tableName":"fangkedengji"}],"menu":"访客登记管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"费用缴纳","menuJump":"列表","tableName":"feiyongjiaona"}],"menu":"费用缴纳管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"车位信息","menuJump":"列表","tableName":"cheweixinxi"}],"menu":"车位信息管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"车牌号更换","menuJump":"列表","tableName":"chepaihaogenghuan"}],"menu":"车牌号更换管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"疫情数据","menuJump":"列表","tableName":"yiqingshuju"}],"menu":"疫情数据管理"},{"child":[{"buttons":["查看","修改","删除","审核"],"menu":"投诉反馈","menuJump":"列表","tableName":"tousufankui"}],"menu":"投诉反馈管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"小区论坛","tableName":"forum"}],"menu":"小区论坛"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"物业公告","tableName":"news"},{"buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"疫情数据列表","menuJump":"列表","tableName":"yiqingshuju"}],"menu":"疫情数据模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"核酸检测报告","menuJump":"列表","tableName":"hesuanjiancebaogao"}],"menu":"核酸检测报告管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"疫情上报","menuJump":"列表","tableName":"yiqingshangbao"}],"menu":"疫情上报管理"},{"child":[{"buttons":["查看"],"menu":"访客登记","menuJump":"列表","tableName":"fangkedengji"}],"menu":"访客登记管理"},{"child":[{"buttons":["查看","支付"],"menu":"费用缴纳","menuJump":"列表","tableName":"feiyongjiaona"}],"menu":"费用缴纳管理"},{"child":[{"buttons":["查看","更换"],"menu":"车位信息","menuJump":"列表","tableName":"cheweixinxi"}],"menu":"车位信息管理"},{"child":[{"buttons":["查看","修改","删除"],"menu":"车牌号更换","menuJump":"列表","tableName":"chepaihaogenghuan"}],"menu":"车牌号更换管理"},{"child":[{"buttons":["新增","查看","修改","删除"],"menu":"投诉反馈","menuJump":"列表","tableName":"tousufankui"}],"menu":"投诉反馈管理"}],"frontMenu":[{"child":[{"buttons":["查看"],"menu":"疫情数据列表","menuJump":"列表","tableName":"yiqingshuju"}],"menu":"疫情数据模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"业主","tableName":"yezhu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
