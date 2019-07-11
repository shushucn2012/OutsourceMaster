package com.asuper.outsourcemaster.moduel.home.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shubei on 2017/9/13.
 */

public class ConfigBean {


    /**
     * industry : [{"id":1,"pid":0,"name":"医疗卫生"},{"id":2,"pid":1,"name":"养身保健"},{"id":3,"pid":1,"name":"医惠问答"},{"id":4,"pid":1,"name":"远程医疗"},{"id":5,"pid":1,"name":"专科门户"},{"id":6,"pid":1,"name":"社区医疗"},{"id":7,"pid":1,"name":"其他"},{"id":8,"pid":0,"name":"电商行业"},{"id":9,"pid":8,"name":"跨境电商"},{"id":10,"pid":8,"name":"农村电商"},{"id":11,"pid":8,"name":"零售电商"},{"id":12,"pid":8,"name":"生鲜电商"},{"id":13,"pid":8,"name":"O2O电商"},{"id":14,"pid":8,"name":"分销电商"},{"id":15,"pid":8,"name":"电视购物"},{"id":16,"pid":8,"name":"其他"},{"id":17,"pid":0,"name":"体育运动"},{"id":18,"pid":17,"name":"户外运动"},{"id":19,"pid":17,"name":"体育赛事"},{"id":20,"pid":17,"name":"竞技"},{"id":21,"pid":17,"name":"体育场馆"},{"id":22,"pid":17,"name":"体育摄影"},{"id":23,"pid":17,"name":"其他"},{"id":24,"pid":0,"name":"餐饮行业"},{"id":25,"pid":24,"name":"外卖餐饮"},{"id":26,"pid":24,"name":"连锁店餐饮"},{"id":27,"pid":24,"name":"休闲饮品"},{"id":28,"pid":24,"name":"其他"},{"id":29,"pid":0,"name":"金融保险"},{"id":30,"pid":29,"name":"理财保险"},{"id":31,"pid":29,"name":"众筹"},{"id":32,"pid":29,"name":"网贷"},{"id":33,"pid":29,"name":"P2P"},{"id":34,"pid":29,"name":"股票基金"},{"id":35,"pid":29,"name":"虚拟货币"},{"id":36,"pid":29,"name":"其他"},{"id":37,"pid":0,"name":"教育培训"},{"id":38,"pid":37,"name":"早教"},{"id":39,"pid":37,"name":"K12"},{"id":40,"pid":37,"name":"语言学习"},{"id":41,"pid":37,"name":"留学服务"},{"id":42,"pid":37,"name":"兴趣教育"},{"id":43,"pid":37,"name":"培训机构"},{"id":44,"pid":37,"name":"其他"},{"id":45,"pid":0,"name":"3D/VR"},{"id":46,"pid":45,"name":"AI"},{"id":47,"pid":45,"name":"VR"},{"id":48,"pid":45,"name":"机器人"},{"id":49,"pid":45,"name":"其他"},{"id":50,"pid":0,"name":"社区物业"},{"id":51,"pid":50,"name":"物业管理"},{"id":52,"pid":50,"name":"社区电商"},{"id":53,"pid":50,"name":"社区交友"},{"id":54,"pid":50,"name":"智能社区"},{"id":55,"pid":50,"name":"其他"},{"id":56,"pid":0,"name":"生活服务"},{"id":57,"pid":56,"name":"生活缴费"},{"id":58,"pid":56,"name":"物流快递"},{"id":59,"pid":56,"name":"房屋地产"},{"id":60,"pid":56,"name":"家政服务"},{"id":61,"pid":56,"name":"票务服务"},{"id":62,"pid":56,"name":"其他"},{"id":63,"pid":2,"name":"拔火罐"},{"id":64,"pid":3,"name":"暂不选择"},{"id":65,"pid":4,"name":"暂不选择"},{"id":66,"pid":5,"name":"暂不选择"},{"id":67,"pid":6,"name":"暂不选择"},{"id":68,"pid":7,"name":"暂不选择"},{"id":69,"pid":9,"name":"暂不选择"},{"id":70,"pid":10,"name":"暂不选择"},{"id":71,"pid":11,"name":"暂不选择"},{"id":72,"pid":12,"name":"暂不选择"},{"id":73,"pid":13,"name":"暂不选择"},{"id":74,"pid":14,"name":"暂不选择"},{"id":75,"pid":15,"name":"暂不选择"},{"id":76,"pid":16,"name":"暂不选择"},{"id":77,"pid":18,"name":"暂不选择"},{"id":78,"pid":19,"name":"暂不选择"},{"id":79,"pid":20,"name":"暂不选择"},{"id":80,"pid":21,"name":"暂不选择"},{"id":81,"pid":22,"name":"暂不选择"},{"id":82,"pid":23,"name":"暂不选择"},{"id":83,"pid":25,"name":"暂不选择"},{"id":84,"pid":26,"name":"暂不选择"},{"id":85,"pid":27,"name":"暂不选择"},{"id":86,"pid":28,"name":"暂不选择"},{"id":87,"pid":30,"name":"暂不选择"},{"id":88,"pid":31,"name":"暂不选择"},{"id":89,"pid":32,"name":"暂不选择"},{"id":90,"pid":33,"name":"暂不选择"},{"id":91,"pid":34,"name":"暂不选择"},{"id":92,"pid":35,"name":"暂不选择"},{"id":93,"pid":36,"name":"暂不选择"},{"id":94,"pid":38,"name":"暂不选择"},{"id":95,"pid":39,"name":"暂不选择"},{"id":96,"pid":40,"name":"暂不选择"},{"id":97,"pid":41,"name":"暂不选择"},{"id":98,"pid":42,"name":"暂不选择"},{"id":99,"pid":43,"name":"暂不选择"},{"id":100,"pid":44,"name":"暂不选择"},{"id":101,"pid":46,"name":"暂不选择"},{"id":102,"pid":47,"name":"暂不选择"},{"id":103,"pid":48,"name":"暂不选择"},{"id":104,"pid":49,"name":"暂不选择"},{"id":105,"pid":51,"name":"暂不选择"},{"id":106,"pid":52,"name":"暂不选择"},{"id":107,"pid":53,"name":"暂不选择"},{"id":108,"pid":54,"name":"暂不选择"},{"id":109,"pid":55,"name":"暂不选择"},{"id":110,"pid":57,"name":"暂不选择"},{"id":111,"pid":58,"name":"暂不选择"},{"id":112,"pid":59,"name":"暂不选择"},{"id":113,"pid":60,"name":"暂不选择"},{"id":114,"pid":61,"name":"暂不选择"},{"id":115,"pid":62,"name":"暂不选择"}]
     * category : [{"id":1,"pid":0,"name":"定制开发","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1713/定制开发.png"},{"id":2,"pid":1,"name":"移动应用","icon":""},{"id":3,"pid":1,"name":"微信开发","icon":""},{"id":4,"pid":1,"name":"系统开发","icon":""},{"id":5,"pid":1,"name":"其他","icon":""},{"id":6,"pid":2,"name":"暂无分类","icon":""},{"id":7,"pid":0,"name":"创意设计","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1712/创意设计.png"},{"id":8,"pid":7,"name":"静态设计","icon":""},{"id":9,"pid":8,"name":"平面设计","icon":""},{"id":10,"pid":8,"name":"插画设计","icon":""},{"id":11,"pid":8,"name":"VI设计","icon":""},{"id":12,"pid":8,"name":"LOGO设计","icon":""},{"id":13,"pid":7,"name":"动态设计","icon":""},{"id":14,"pid":13,"name":"交互设计","icon":""},{"id":15,"pid":13,"name":"动画设计","icon":""},{"id":16,"pid":13,"name":"其他设计","icon":""},{"id":17,"pid":16,"name":"其他","icon":""},{"id":18,"pid":0,"name":"人才服务","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1713/人才服务.png"},{"id":19,"pid":18,"name":"产品","icon":""},{"id":20,"pid":19,"name":"产品经理","icon":""},{"id":21,"pid":19,"name":"项目经理","icon":""},{"id":22,"pid":19,"name":"其他","icon":""},{"id":23,"pid":18,"name":"咨询","icon":""},{"id":24,"pid":23,"name":"产品咨询","icon":""},{"id":25,"pid":28,"name":"其他","icon":""},{"id":26,"pid":25,"name":"其他","icon":""},{"id":27,"pid":0,"name":"网站建设","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1714/网站开发.png"},{"id":28,"pid":27,"name":"前端开发","icon":""},{"id":29,"pid":28,"name":"H5","icon":""},{"id":30,"pid":28,"name":"ＷＥＢ网站","icon":""},{"id":31,"pid":28,"name":"手机站","icon":""},{"id":32,"pid":27,"name":"后端开发","icon":""},{"id":33,"pid":32,"name":"功能开发","icon":""},{"id":34,"pid":32,"name":"接口开发","icon":""},{"id":35,"pid":27,"name":"其他","icon":""},{"id":36,"pid":35,"name":"其他","icon":""},{"id":37,"pid":0,"name":"APP开发","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1714/移动开发.png"},{"id":38,"pid":37,"name":"双版本","icon":""},{"id":39,"pid":36,"name":"暂不选择","icon":""},{"id":40,"pid":37,"name":"ios","icon":""},{"id":41,"pid":37,"name":"android","icon":""},{"id":42,"pid":37,"name":"其他","icon":""},{"id":43,"pid":0,"name":"微信开发","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1714/微信开发.png"},{"id":44,"pid":43,"name":"小程序","icon":""},{"id":45,"pid":43,"name":"微信公账号","icon":""},{"id":46,"pid":43,"name":"其他","icon":""},{"id":47,"pid":43,"name":"暂不选择","icon":""},{"id":48,"pid":0,"name":"系统开发","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1714/系统开发.png"},{"id":49,"pid":48,"name":"ERP","icon":""},{"id":50,"pid":48,"name":"CRM","icon":""},{"id":51,"pid":48,"name":"OA","icon":""},{"id":52,"pid":48,"name":"CMS","icon":""},{"id":53,"pid":48,"name":"其他","icon":""},{"id":54,"pid":49,"name":"暂不选择","icon":""},{"id":55,"pid":0,"name":"产品/UI设计","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1713/产品UI设计.png"},{"id":56,"pid":55,"name":"产品原型","icon":""},{"id":57,"pid":55,"name":"UI设计","icon":""},{"id":58,"pid":55,"name":"交互设计","icon":""},{"id":59,"pid":55,"name":"其他","icon":""},{"id":60,"pid":56,"name":"暂不选择","icon":""},{"id":61,"pid":0,"name":"测试服务","icon":"http://ofotn744c.bkt.clouddn.com/20170830/1713/产品众测.png"},{"id":62,"pid":61,"name":"众包测试","icon":""},{"id":63,"pid":61,"name":"自动化测试","icon":""},{"id":64,"pid":61,"name":"测试用例","icon":""},{"id":65,"pid":61,"name":"其他","icon":""},{"id":66,"pid":62,"name":"暂不选择","icon":""},{"id":88,"pid":3,"name":"暂不选择","icon":""},{"id":89,"pid":4,"name":"暂不选择","icon":""},{"id":90,"pid":5,"name":"暂不选择","icon":""},{"id":91,"pid":38,"name":"暂不选择","icon":""},{"id":92,"pid":40,"name":"暂不选择","icon":""},{"id":93,"pid":41,"name":"暂不选择","icon":""},{"id":94,"pid":42,"name":"暂不选择","icon":""},{"id":95,"pid":44,"name":"暂不选择","icon":""},{"id":96,"pid":45,"name":"暂不选择","icon":""},{"id":97,"pid":46,"name":"暂不选择","icon":""},{"id":98,"pid":47,"name":"暂不选择","icon":""},{"id":99,"pid":50,"name":"暂不选择","icon":""},{"id":100,"pid":51,"name":"暂不选择","icon":""},{"id":101,"pid":52,"name":"暂不选择","icon":""},{"id":102,"pid":53,"name":"暂不选择","icon":""},{"id":103,"pid":57,"name":"暂不选择","icon":""},{"id":104,"pid":58,"name":"暂不选择","icon":""},{"id":105,"pid":59,"name":"暂不选择","icon":""},{"id":106,"pid":63,"name":"暂不选择","icon":""},{"id":107,"pid":64,"name":"暂不选择","icon":""},{"id":108,"pid":65,"name":"暂不选择","icon":""}]
     * use_type : [{"id":1,"pid":0,"name":"工具"},{"id":2,"pid":1,"name":"支付工具"},{"id":3,"pid":1,"name":"日常应用工具"},{"id":4,"pid":1,"name":"图片摄影"},{"id":5,"pid":1,"name":"网络云盘"},{"id":6,"pid":1,"name":"地图"},{"id":7,"pid":1,"name":"比价"},{"id":8,"pid":1,"name":"其他"},{"id":9,"pid":2,"name":"暂不选择"},{"id":10,"pid":0,"name":"内容"},{"id":11,"pid":10,"name":"付费阅读"},{"id":12,"pid":10,"name":"付费课程"},{"id":13,"pid":10,"name":"公开课"},{"id":14,"pid":10,"name":"咨询平台"},{"id":15,"pid":10,"name":"内容聚合"},{"id":16,"pid":10,"name":"其他"},{"id":17,"pid":11,"name":"暂不选择"},{"id":18,"pid":0,"name":"社交"},{"id":19,"pid":18,"name":"贴吧论坛"},{"id":20,"pid":18,"name":"视频社交"},{"id":21,"pid":18,"name":"图片社交"},{"id":22,"pid":18,"name":"社区"},{"id":23,"pid":18,"name":"其他"},{"id":24,"pid":19,"name":"暂不选择"},{"id":25,"pid":0,"name":"人工智能"},{"id":26,"pid":25,"name":"智能家居"},{"id":27,"pid":25,"name":"穿戴设备"},{"id":28,"pid":25,"name":"智能出行"},{"id":29,"pid":25,"name":"智能硬件"},{"id":30,"pid":25,"name":"机器人"},{"id":31,"pid":25,"name":"其他"},{"id":32,"pid":26,"name":"暂不选择"},{"id":33,"pid":0,"name":"交易"},{"id":34,"pid":33,"name":"商城"},{"id":35,"pid":33,"name":"团购"},{"id":36,"pid":33,"name":"电商平台"},{"id":37,"pid":33,"name":"在线定制"},{"id":38,"pid":33,"name":"交易担保"},{"id":39,"pid":33,"name":"其他"},{"id":40,"pid":34,"name":"暂不选择"},{"id":41,"pid":0,"name":"系统"},{"id":42,"pid":41,"name":"CMS系统"},{"id":43,"pid":41,"name":"ERP系统"},{"id":44,"pid":41,"name":"OA系统"},{"id":45,"pid":41,"name":"CRM系统"},{"id":46,"pid":41,"name":"其他"},{"id":47,"pid":42,"name":"暂不选择"},{"id":48,"pid":0,"name":"平台"},{"id":49,"pid":48,"name":"教学平台"},{"id":50,"pid":48,"name":"内容管理"},{"id":51,"pid":48,"name":"生活服务"},{"id":52,"pid":48,"name":"众包平台"},{"id":53,"pid":48,"name":"其他"},{"id":54,"pid":53,"name":"暂不选择"},{"id":55,"pid":0,"name":"游戏"},{"id":56,"pid":55,"name":"手机网游"},{"id":57,"pid":55,"name":"网络游戏"},{"id":58,"pid":55,"name":"扑克棋牌"},{"id":59,"pid":55,"name":"角色扮演"},{"id":60,"pid":55,"name":"体育竞技"},{"id":61,"pid":55,"name":"其他"},{"id":62,"pid":56,"name":"暂不选择"},{"id":63,"pid":3,"name":"暂不选择"},{"id":64,"pid":4,"name":"暂不选择"},{"id":65,"pid":5,"name":"暂不选择"},{"id":66,"pid":6,"name":"暂不选择"},{"id":67,"pid":7,"name":"暂不选择"},{"id":68,"pid":8,"name":"暂不选择"},{"id":69,"pid":12,"name":"暂不选择"},{"id":70,"pid":13,"name":"暂不选择"},{"id":71,"pid":14,"name":"暂不选择"},{"id":72,"pid":15,"name":"暂不选择"},{"id":73,"pid":16,"name":"暂不选择"},{"id":74,"pid":20,"name":"暂不选择"},{"id":75,"pid":21,"name":"暂不选择"},{"id":76,"pid":22,"name":"暂不选择"},{"id":77,"pid":23,"name":"暂不选择"},{"id":78,"pid":27,"name":"暂不选择"},{"id":79,"pid":28,"name":"暂不选择"},{"id":80,"pid":29,"name":"暂不选择"},{"id":81,"pid":30,"name":"暂不选择"},{"id":82,"pid":31,"name":"暂不选择"},{"id":83,"pid":35,"name":"暂不选择"},{"id":84,"pid":36,"name":"暂不选择"},{"id":85,"pid":37,"name":"暂不选择"},{"id":86,"pid":38,"name":"暂不选择"},{"id":87,"pid":39,"name":"暂不选择"},{"id":88,"pid":43,"name":"暂不选择"},{"id":89,"pid":44,"name":"暂不选择"},{"id":90,"pid":45,"name":"暂不选择"},{"id":91,"pid":46,"name":"暂不选择"},{"id":92,"pid":49,"name":"暂不选择"},{"id":93,"pid":50,"name":"暂不选择"},{"id":94,"pid":51,"name":"暂不选择"},{"id":95,"pid":52,"name":"暂不选择"},{"id":96,"pid":57,"name":"暂不选择"},{"id":97,"pid":58,"name":"暂不选择"},{"id":98,"pid":59,"name":"暂不选择"},{"id":99,"pid":60,"name":"暂不选择"},{"id":100,"pid":61,"name":"暂不选择"}]
     * province_city : [{"id":1,"p_id":0,"name":"北京","sort":0},{"id":2,"p_id":0,"name":"上海","sort":0},{"id":3,"p_id":0,"name":"天津","sort":0},{"id":4,"p_id":0,"name":"重庆","sort":0},{"id":5,"p_id":0,"name":"河北","sort":0},{"id":6,"p_id":0,"name":"山西","sort":0},{"id":7,"p_id":0,"name":"河南","sort":0},{"id":8,"p_id":0,"name":"辽宁","sort":0},{"id":9,"p_id":0,"name":"吉林","sort":0},{"id":10,"p_id":0,"name":"黑龙江","sort":0},{"id":11,"p_id":0,"name":"内蒙古","sort":0},{"id":12,"p_id":0,"name":"江苏","sort":0},{"id":13,"p_id":0,"name":"山东","sort":0},{"id":14,"p_id":0,"name":"安徽","sort":0},{"id":15,"p_id":0,"name":"浙江","sort":0},{"id":16,"p_id":0,"name":"福建","sort":0},{"id":17,"p_id":0,"name":"湖北","sort":0},{"id":18,"p_id":0,"name":"湖南","sort":0},{"id":19,"p_id":0,"name":"广东","sort":0},{"id":20,"p_id":0,"name":"广西","sort":0},{"id":21,"p_id":0,"name":"江西","sort":0},{"id":22,"p_id":0,"name":"四川","sort":0},{"id":23,"p_id":0,"name":"海南","sort":0},{"id":24,"p_id":0,"name":"贵州","sort":0},{"id":25,"p_id":0,"name":"云南","sort":0},{"id":26,"p_id":0,"name":"西藏","sort":0},{"id":27,"p_id":0,"name":"陕西","sort":0},{"id":28,"p_id":0,"name":"甘肃","sort":0},{"id":29,"p_id":0,"name":"青海","sort":0},{"id":30,"p_id":0,"name":"宁夏","sort":0},{"id":31,"p_id":0,"name":"新疆","sort":0},{"id":32,"p_id":0,"name":"台湾","sort":0},{"id":72,"p_id":1,"name":"朝阳区","sort":0},{"id":78,"p_id":2,"name":"黄浦区","sort":0},{"id":84,"p_id":0,"name":"钓鱼岛","sort":0},{"id":113,"p_id":4,"name":"万州区","sort":0},{"id":114,"p_id":4,"name":"涪陵区","sort":0},{"id":115,"p_id":4,"name":"梁平县","sort":0},{"id":119,"p_id":4,"name":"南川区","sort":0},{"id":123,"p_id":4,"name":"潼南县","sort":0},{"id":126,"p_id":4,"name":"大足区","sort":0},{"id":128,"p_id":4,"name":"黔江区","sort":0},{"id":129,"p_id":4,"name":"武隆县","sort":0},{"id":130,"p_id":4,"name":"丰都县","sort":0},{"id":131,"p_id":4,"name":"奉节县","sort":0},{"id":132,"p_id":4,"name":"开县","sort":0},{"id":133,"p_id":4,"name":"云阳县","sort":0},{"id":134,"p_id":4,"name":"忠县","sort":0},{"id":135,"p_id":4,"name":"巫溪县","sort":0},{"id":136,"p_id":4,"name":"巫山县","sort":0},{"id":137,"p_id":4,"name":"石柱县","sort":0},{"id":138,"p_id":4,"name":"彭水县","sort":0},{"id":139,"p_id":4,"name":"垫江县","sort":0},{"id":140,"p_id":4,"name":"酉阳县","sort":0},{"id":141,"p_id":4,"name":"秀山县","sort":0},{"id":142,"p_id":5,"name":"石家庄市","sort":0},{"id":148,"p_id":5,"name":"邯郸市","sort":0},{"id":164,"p_id":5,"name":"邢台市","sort":0},{"id":199,"p_id":5,"name":"保定市","sort":0},{"id":224,"p_id":5,"name":"张家口市","sort":0},{"id":239,"p_id":5,"name":"承德市","sort":0},{"id":248,"p_id":5,"name":"秦皇岛市","sort":0},{"id":258,"p_id":5,"name":"唐山市","sort":0},{"id":264,"p_id":5,"name":"沧州市","sort":0},{"id":274,"p_id":5,"name":"廊坊市","sort":0},{"id":275,"p_id":5,"name":"衡水市","sort":0},{"id":303,"p_id":6,"name":"太原市","sort":0},{"id":309,"p_id":6,"name":"大同市","sort":0},{"id":318,"p_id":6,"name":"阳泉市","sort":0},{"id":325,"p_id":6,"name":"晋城市","sort":0},{"id":330,"p_id":6,"name":"朔州市","sort":0},{"id":336,"p_id":6,"name":"晋中市","sort":0},{"id":350,"p_id":6,"name":"忻州市","sort":0},{"id":368,"p_id":6,"name":"吕梁市","sort":0},{"id":379,"p_id":6,"name":"临汾市","sort":0},{"id":398,"p_id":6,"name":"运城市","sort":0},{"id":412,"p_id":7,"name":"郑州市","sort":0},{"id":420,"p_id":7,"name":"开封市","sort":0},{"id":427,"p_id":7,"name":"洛阳市","sort":0},{"id":438,"p_id":7,"name":"平顶山市","sort":0},{"id":446,"p_id":7,"name":"焦作市","sort":0},{"id":454,"p_id":7,"name":"鹤壁市","sort":0},{"id":458,"p_id":7,"name":"新乡市","sort":0},{"id":468,"p_id":7,"name":"安阳市","sort":0},{"id":475,"p_id":7,"name":"濮阳市","sort":0},{"id":482,"p_id":7,"name":"许昌市","sort":0},{"id":489,"p_id":7,"name":"漯河市","sort":0},{"id":495,"p_id":7,"name":"三门峡市","sort":0},{"id":502,"p_id":7,"name":"南阳市","sort":0},{"id":517,"p_id":7,"name":"商丘市","sort":0},{"id":527,"p_id":7,"name":"周口市","sort":0},{"id":538,"p_id":7,"name":"驻马店市","sort":0},{"id":549,"p_id":7,"name":"信阳市","sort":0},{"id":560,"p_id":8,"name":"沈阳市","sort":0},{"id":573,"p_id":8,"name":"大连市","sort":0},{"id":579,"p_id":8,"name":"鞍山市","sort":0},{"id":584,"p_id":8,"name":"抚顺市","sort":0},{"id":589,"p_id":8,"name":"本溪市","sort":0},{"id":593,"p_id":8,"name":"丹东市","sort":0},{"id":598,"p_id":8,"name":"锦州市","sort":0},{"id":604,"p_id":8,"name":"葫芦岛市","sort":0},{"id":609,"p_id":8,"name":"营口市","sort":0},{"id":613,"p_id":8,"name":"盘锦市","sort":0},{"id":617,"p_id":8,"name":"阜新市","sort":0},{"id":621,"p_id":8,"name":"辽阳市","sort":0},{"id":632,"p_id":8,"name":"朝阳市","sort":0},{"id":639,"p_id":9,"name":"长春市","sort":0},{"id":644,"p_id":9,"name":"吉林市","sort":0},{"id":651,"p_id":9,"name":"四平市","sort":0},{"id":657,"p_id":9,"name":"通化市","sort":0},{"id":664,"p_id":9,"name":"白山市","sort":0},{"id":674,"p_id":9,"name":"松原市","sort":0},{"id":681,"p_id":9,"name":"白城市","sort":0},{"id":687,"p_id":9,"name":"延边州","sort":0},{"id":698,"p_id":10,"name":"哈尔滨市","sort":0},{"id":712,"p_id":10,"name":"齐齐哈尔市","sort":0},{"id":727,"p_id":10,"name":"鹤岗市","sort":0},{"id":731,"p_id":10,"name":"双鸭山市","sort":0},{"id":737,"p_id":10,"name":"鸡西市","sort":0},{"id":742,"p_id":10,"name":"大庆市","sort":0},{"id":753,"p_id":10,"name":"伊春市","sort":0},{"id":757,"p_id":10,"name":"牡丹江市","sort":0},{"id":765,"p_id":10,"name":"佳木斯市","sort":0},{"id":773,"p_id":10,"name":"七台河市","sort":0},{"id":776,"p_id":10,"name":"黑河市","sort":0},{"id":782,"p_id":10,"name":"绥化市","sort":0},{"id":793,"p_id":10,"name":"大兴安岭地区","sort":0},{"id":799,"p_id":11,"name":"呼和浩特市","sort":0},{"id":805,"p_id":11,"name":"包头市","sort":0},{"id":810,"p_id":11,"name":"乌海市","sort":0},{"id":812,"p_id":11,"name":"赤峰市","sort":0},{"id":823,"p_id":11,"name":"乌兰察布市","sort":0},{"id":835,"p_id":11,"name":"锡林郭勒盟","sort":0},{"id":848,"p_id":11,"name":"呼伦贝尔市","sort":0},{"id":870,"p_id":11,"name":"鄂尔多斯市","sort":0},{"id":880,"p_id":11,"name":"巴彦淖尔市","sort":0},{"id":891,"p_id":11,"name":"阿拉善盟","sort":0},{"id":895,"p_id":11,"name":"兴安盟","sort":0},{"id":902,"p_id":11,"name":"通辽市","sort":0},{"id":904,"p_id":12,"name":"南京市","sort":0},{"id":911,"p_id":12,"name":"徐州市","sort":0},{"id":919,"p_id":12,"name":"连云港市","sort":0},{"id":925,"p_id":12,"name":"淮安市","sort":0},{"id":933,"p_id":12,"name":"宿迁市","sort":0},{"id":939,"p_id":12,"name":"盐城市","sort":0},{"id":951,"p_id":12,"name":"扬州市","sort":0},{"id":959,"p_id":12,"name":"泰州市","sort":0},{"id":965,"p_id":12,"name":"南通市","sort":0},{"id":972,"p_id":12,"name":"镇江市","sort":0},{"id":978,"p_id":12,"name":"常州市","sort":0},{"id":984,"p_id":12,"name":"无锡市","sort":0},{"id":988,"p_id":12,"name":"苏州市","sort":0},{"id":1000,"p_id":13,"name":"济南市","sort":0},{"id":1007,"p_id":13,"name":"青岛市","sort":0},{"id":1016,"p_id":13,"name":"淄博市","sort":0},{"id":1022,"p_id":13,"name":"枣庄市","sort":0},{"id":1025,"p_id":13,"name":"东营市","sort":0},{"id":1032,"p_id":13,"name":"潍坊市","sort":0},{"id":1042,"p_id":13,"name":"烟台市","sort":0},{"id":1053,"p_id":13,"name":"威海市","sort":0},{"id":1058,"p_id":13,"name":"莱芜市","sort":0},{"id":1060,"p_id":13,"name":"德州市","sort":0},{"id":1072,"p_id":13,"name":"临沂市","sort":0},{"id":1081,"p_id":13,"name":"聊城市","sort":0},{"id":1090,"p_id":13,"name":"滨州市","sort":0},{"id":1099,"p_id":13,"name":"菏泽市","sort":0},{"id":1108,"p_id":13,"name":"日照市","sort":0},{"id":1112,"p_id":13,"name":"泰安市","sort":0},{"id":1114,"p_id":14,"name":"铜陵市","sort":0},{"id":1116,"p_id":14,"name":"合肥市","sort":0},{"id":1121,"p_id":14,"name":"淮南市","sort":0},{"id":1124,"p_id":14,"name":"淮北市","sort":0},{"id":1127,"p_id":14,"name":"芜湖市","sort":0},{"id":1132,"p_id":14,"name":"蚌埠市","sort":0},{"id":1137,"p_id":14,"name":"马鞍山市","sort":0},{"id":1140,"p_id":14,"name":"安庆市","sort":0},{"id":1151,"p_id":14,"name":"黄山市","sort":0},{"id":1158,"p_id":15,"name":"宁波市","sort":0},{"id":1159,"p_id":14,"name":"滁州市","sort":0},{"id":1167,"p_id":14,"name":"阜阳市","sort":0},{"id":1174,"p_id":14,"name":"亳州市","sort":0},{"id":1180,"p_id":14,"name":"宿州市","sort":0},{"id":1201,"p_id":14,"name":"池州市","sort":0},{"id":1206,"p_id":14,"name":"六安市","sort":0},{"id":1213,"p_id":15,"name":"杭州市","sort":0},{"id":1233,"p_id":15,"name":"温州市","sort":0},{"id":1243,"p_id":15,"name":"嘉兴市","sort":0},{"id":1250,"p_id":15,"name":"湖州市","sort":0},{"id":1255,"p_id":15,"name":"绍兴市","sort":0},{"id":1262,"p_id":15,"name":"金华市","sort":0},{"id":1273,"p_id":15,"name":"衢州市","sort":0},{"id":1280,"p_id":15,"name":"丽水市","sort":0},{"id":1290,"p_id":15,"name":"台州市","sort":0},{"id":1298,"p_id":15,"name":"舟山市","sort":0},{"id":1303,"p_id":16,"name":"福州市","sort":0},{"id":1310,"p_id":84,"name":"钓鱼岛","sort":0},{"id":1315,"p_id":16,"name":"厦门市","sort":0},{"id":1317,"p_id":16,"name":"三明市","sort":0},{"id":1329,"p_id":16,"name":"莆田市","sort":0},{"id":1332,"p_id":16,"name":"泉州市","sort":0},{"id":1341,"p_id":16,"name":"漳州市","sort":0},{"id":1352,"p_id":16,"name":"南平市","sort":0},{"id":1362,"p_id":16,"name":"龙岩市","sort":0},{"id":1370,"p_id":16,"name":"宁德市","sort":0},{"id":1381,"p_id":17,"name":"武汉市","sort":0},{"id":1387,"p_id":17,"name":"黄石市","sort":0},{"id":1396,"p_id":17,"name":"襄阳市","sort":0},{"id":1405,"p_id":17,"name":"十堰市","sort":0},{"id":1413,"p_id":17,"name":"荆州市","sort":0},{"id":1421,"p_id":17,"name":"宜昌市","sort":0},{"id":1432,"p_id":17,"name":"孝感市","sort":0},{"id":1441,"p_id":17,"name":"黄冈市","sort":0},{"id":1458,"p_id":17,"name":"咸宁市","sort":0},{"id":1466,"p_id":17,"name":"恩施州","sort":0},{"id":1475,"p_id":17,"name":"鄂州市","sort":0},{"id":1477,"p_id":17,"name":"荆门市","sort":0},{"id":1479,"p_id":17,"name":"随州市","sort":0},{"id":1482,"p_id":18,"name":"长沙市","sort":0},{"id":1488,"p_id":18,"name":"株洲市","sort":0},{"id":1495,"p_id":18,"name":"湘潭市","sort":0},{"id":1501,"p_id":18,"name":"衡阳市","sort":0},{"id":1511,"p_id":18,"name":"邵阳市","sort":0},{"id":1522,"p_id":18,"name":"岳阳市","sort":0},{"id":1530,"p_id":18,"name":"常德市","sort":0},{"id":1540,"p_id":18,"name":"张家界市","sort":0},{"id":1544,"p_id":18,"name":"郴州市","sort":0},{"id":1555,"p_id":18,"name":"益阳市","sort":0},{"id":1560,"p_id":18,"name":"永州市","sort":0},{"id":1574,"p_id":18,"name":"怀化市","sort":0},{"id":1586,"p_id":18,"name":"娄底市","sort":0},{"id":1592,"p_id":18,"name":"湘西州","sort":0},{"id":1601,"p_id":19,"name":"广州市","sort":0},{"id":1607,"p_id":19,"name":"深圳市","sort":0},{"id":1609,"p_id":19,"name":"珠海市","sort":0},{"id":1611,"p_id":19,"name":"汕头市","sort":0},{"id":1617,"p_id":19,"name":"韶关市","sort":0},{"id":1627,"p_id":19,"name":"河源市","sort":0},{"id":1634,"p_id":19,"name":"梅州市","sort":0},{"id":1643,"p_id":19,"name":"惠州市","sort":0},{"id":1650,"p_id":19,"name":"汕尾市","sort":0},{"id":1655,"p_id":19,"name":"东莞市","sort":0},{"id":1657,"p_id":19,"name":"中山市","sort":0},{"id":1659,"p_id":19,"name":"江门市","sort":0},{"id":1666,"p_id":19,"name":"佛山市","sort":0},{"id":1672,"p_id":19,"name":"阳江市","sort":0},{"id":1677,"p_id":19,"name":"湛江市","sort":0},{"id":1684,"p_id":19,"name":"茂名市","sort":0},{"id":1690,"p_id":19,"name":"肇庆市","sort":0},{"id":1698,"p_id":19,"name":"云浮市","sort":0},{"id":1704,"p_id":19,"name":"清远市","sort":0},{"id":1705,"p_id":19,"name":"潮州市","sort":0},{"id":1709,"p_id":19,"name":"揭阳市","sort":0},{"id":1715,"p_id":20,"name":"南宁市","sort":0},{"id":1720,"p_id":20,"name":"柳州市","sort":0},{"id":1726,"p_id":20,"name":"桂林市","sort":0},{"id":1740,"p_id":20,"name":"梧州市","sort":0},{"id":1746,"p_id":20,"name":"北海市","sort":0},{"id":1749,"p_id":20,"name":"防城港市","sort":0},{"id":1753,"p_id":20,"name":"钦州市","sort":0},{"id":1757,"p_id":20,"name":"贵港市","sort":0},{"id":1761,"p_id":20,"name":"玉林市","sort":0},{"id":1792,"p_id":20,"name":"贺州市","sort":0},{"id":1806,"p_id":20,"name":"百色市","sort":0},{"id":1818,"p_id":20,"name":"河池市","sort":0},{"id":1827,"p_id":21,"name":"南昌市","sort":0},{"id":1832,"p_id":21,"name":"景德镇市","sort":0},{"id":1836,"p_id":21,"name":"萍乡市","sort":0},{"id":1842,"p_id":21,"name":"新余市","sort":0},{"id":1845,"p_id":21,"name":"九江市","sort":0},{"id":1857,"p_id":21,"name":"鹰潭市","sort":0},{"id":1861,"p_id":21,"name":"上饶市","sort":0},{"id":1874,"p_id":21,"name":"宜春市","sort":0},{"id":1885,"p_id":21,"name":"抚州市","sort":0},{"id":1898,"p_id":21,"name":"吉安市","sort":0},{"id":1911,"p_id":21,"name":"赣州市","sort":0},{"id":1930,"p_id":22,"name":"成都市","sort":0},{"id":1946,"p_id":22,"name":"自贡市","sort":0},{"id":1950,"p_id":22,"name":"攀枝花市","sort":0},{"id":1954,"p_id":22,"name":"泸州市","sort":0},{"id":1960,"p_id":22,"name":"绵阳市","sort":0},{"id":1962,"p_id":22,"name":"德阳市","sort":0},{"id":1977,"p_id":22,"name":"广元市","sort":0},{"id":1983,"p_id":22,"name":"遂宁市","sort":0},{"id":1988,"p_id":22,"name":"内江市","sort":0},{"id":1993,"p_id":22,"name":"乐山市","sort":0},{"id":2005,"p_id":22,"name":"宜宾市","sort":0},{"id":2016,"p_id":22,"name":"广安市","sort":0},{"id":2022,"p_id":22,"name":"南充市","sort":0},{"id":2033,"p_id":22,"name":"达州市","sort":0},{"id":2042,"p_id":22,"name":"巴中市","sort":0},{"id":2047,"p_id":22,"name":"雅安市","sort":0},{"id":2058,"p_id":22,"name":"眉山市","sort":0},{"id":2065,"p_id":22,"name":"资阳市","sort":0},{"id":2070,"p_id":22,"name":"阿坝州","sort":0},{"id":2084,"p_id":22,"name":"甘孜州","sort":0},{"id":2103,"p_id":22,"name":"凉山州","sort":0},{"id":2121,"p_id":23,"name":"海口市","sort":0},{"id":2144,"p_id":24,"name":"贵阳市","sort":0},{"id":2150,"p_id":24,"name":"六盘水市","sort":0},{"id":2155,"p_id":24,"name":"遵义市","sort":0},{"id":2169,"p_id":24,"name":"铜仁市","sort":0},{"id":2180,"p_id":24,"name":"毕节市","sort":0},{"id":2189,"p_id":24,"name":"安顺市","sort":0},{"id":2196,"p_id":24,"name":"黔西南州","sort":0},{"id":2205,"p_id":24,"name":"黔东南州","sort":0},{"id":2222,"p_id":24,"name":"黔南州","sort":0},{"id":2235,"p_id":25,"name":"昆明市","sort":0},{"id":2247,"p_id":25,"name":"曲靖市","sort":0},{"id":2258,"p_id":25,"name":"玉溪市","sort":0},{"id":2270,"p_id":25,"name":"昭通市","sort":0},{"id":2281,"p_id":25,"name":"普洱市","sort":0},{"id":2291,"p_id":25,"name":"临沧市","sort":0},{"id":2298,"p_id":25,"name":"保山市","sort":0},{"id":2304,"p_id":25,"name":"丽江市","sort":0},{"id":2309,"p_id":25,"name":"文山州","sort":0},{"id":2318,"p_id":25,"name":"红河州","sort":0},{"id":2332,"p_id":25,"name":"西双版纳州","sort":0},{"id":2336,"p_id":25,"name":"楚雄州","sort":0},{"id":2347,"p_id":25,"name":"大理州","sort":0},{"id":2360,"p_id":25,"name":"德宏州","sort":0},{"id":2366,"p_id":25,"name":"怒江州","sort":0},{"id":2376,"p_id":27,"name":"西安市","sort":0},{"id":2386,"p_id":27,"name":"铜川市","sort":0},{"id":2390,"p_id":27,"name":"宝鸡市","sort":0},{"id":2402,"p_id":27,"name":"咸阳市","sort":0},{"id":2416,"p_id":27,"name":"渭南市","sort":0},{"id":2428,"p_id":27,"name":"延安市","sort":0},{"id":2442,"p_id":27,"name":"汉中市","sort":0},{"id":2454,"p_id":27,"name":"榆林市","sort":0},{"id":2468,"p_id":27,"name":"商洛市","sort":0},{"id":2476,"p_id":27,"name":"安康市","sort":0},{"id":2487,"p_id":28,"name":"兰州市","sort":0},{"id":2492,"p_id":28,"name":"金昌市","sort":0},{"id":2495,"p_id":28,"name":"白银市","sort":0},{"id":2501,"p_id":28,"name":"天水市","sort":0},{"id":2509,"p_id":28,"name":"嘉峪关市","sort":0},{"id":2518,"p_id":28,"name":"平凉市","sort":0},{"id":2525,"p_id":28,"name":"庆阳市","sort":0},{"id":2534,"p_id":28,"name":"陇南市","sort":0},{"id":2544,"p_id":28,"name":"武威市","sort":0},{"id":2549,"p_id":28,"name":"张掖市","sort":0},{"id":2556,"p_id":28,"name":"酒泉市","sort":0},{"id":2564,"p_id":28,"name":"甘南州","sort":0},{"id":2573,"p_id":28,"name":"临夏州","sort":0},{"id":2580,"p_id":29,"name":"西宁市","sort":0},{"id":2585,"p_id":29,"name":"海东地区","sort":0},{"id":2592,"p_id":29,"name":"海北州","sort":0},{"id":2597,"p_id":29,"name":"黄南州","sort":0},{"id":2603,"p_id":29,"name":"海南州","sort":0},{"id":2605,"p_id":29,"name":"果洛州","sort":0},{"id":2612,"p_id":29,"name":"玉树州","sort":0},{"id":2620,"p_id":29,"name":"海西州","sort":0},{"id":2628,"p_id":30,"name":"银川市","sort":0},{"id":2632,"p_id":30,"name":"石嘴山市","sort":0},{"id":2637,"p_id":30,"name":"吴忠市","sort":0},{"id":2644,"p_id":30,"name":"固原市","sort":0},{"id":2652,"p_id":31,"name":"乌鲁木齐市","sort":0},{"id":2654,"p_id":31,"name":"克拉玛依市","sort":0},{"id":2656,"p_id":31,"name":"石河子市","sort":0},{"id":2658,"p_id":31,"name":"吐鲁番地区","sort":0},{"id":2662,"p_id":31,"name":"哈密地区","sort":0},{"id":2666,"p_id":31,"name":"和田地区","sort":0},{"id":2675,"p_id":31,"name":"阿克苏地区","sort":0},{"id":2686,"p_id":31,"name":"喀什地区","sort":0},{"id":2699,"p_id":31,"name":"克孜勒苏州","sort":0},{"id":2704,"p_id":31,"name":"巴音郭楞州","sort":0},{"id":2714,"p_id":31,"name":"昌吉州","sort":0},{"id":2723,"p_id":31,"name":"博尔塔拉州","sort":0},{"id":2727,"p_id":31,"name":"伊犁州","sort":0},{"id":2736,"p_id":31,"name":"塔城地区","sort":0},{"id":2744,"p_id":31,"name":"阿勒泰地区","sort":0},{"id":2768,"p_id":32,"name":"台湾","sort":0},{"id":2780,"p_id":7,"name":"济源市","sort":0},{"id":2800,"p_id":1,"name":"海淀区","sort":0},{"id":2801,"p_id":1,"name":"西城区","sort":0},{"id":2802,"p_id":1,"name":"东城区","sort":0},{"id":2803,"p_id":1,"name":"崇文区","sort":0},{"id":2804,"p_id":1,"name":"宣武区","sort":0},{"id":2805,"p_id":1,"name":"丰台区","sort":0},{"id":2806,"p_id":1,"name":"石景山区","sort":0},{"id":2807,"p_id":1,"name":"门头沟","sort":0},{"id":2808,"p_id":1,"name":"房山区","sort":0},{"id":2809,"p_id":1,"name":"通州区","sort":0},{"id":2810,"p_id":1,"name":"大兴区","sort":0},{"id":2812,"p_id":1,"name":"顺义区","sort":0},{"id":2813,"p_id":2,"name":"徐汇区","sort":0},{"id":2814,"p_id":1,"name":"怀柔区","sort":0},{"id":2815,"p_id":2,"name":"长宁区","sort":0},{"id":2816,"p_id":1,"name":"密云区","sort":0},{"id":2817,"p_id":2,"name":"静安区","sort":0},{"id":2820,"p_id":2,"name":"闸北区","sort":0},{"id":2822,"p_id":2,"name":"虹口区","sort":0},{"id":2823,"p_id":2,"name":"杨浦区","sort":0},{"id":2824,"p_id":2,"name":"宝山区","sort":0},{"id":2825,"p_id":2,"name":"闵行区","sort":0},{"id":2826,"p_id":2,"name":"嘉定区","sort":0},{"id":2830,"p_id":2,"name":"浦东新区","sort":0},{"id":2833,"p_id":2,"name":"青浦区","sort":0},{"id":2834,"p_id":2,"name":"松江区","sort":0},{"id":2835,"p_id":2,"name":"金山区","sort":0},{"id":2837,"p_id":2,"name":"奉贤区","sort":0},{"id":2841,"p_id":2,"name":"普陀区","sort":0},{"id":2900,"p_id":13,"name":"济宁市","sort":0},{"id":2901,"p_id":1,"name":"昌平区","sort":0},{"id":2919,"p_id":2,"name":"崇明县","sort":0},{"id":2922,"p_id":17,"name":"潜江市","sort":0},{"id":2951,"p_id":26,"name":"拉萨市","sort":0},{"id":2953,"p_id":1,"name":"平谷区","sort":0},{"id":2971,"p_id":14,"name":"宣城市","sort":0},{"id":2980,"p_id":17,"name":"天门市","sort":0},{"id":2983,"p_id":17,"name":"仙桃市","sort":0},{"id":2992,"p_id":9,"name":"辽源市","sort":0},{"id":3034,"p_id":23,"name":"儋州市","sort":0},{"id":3044,"p_id":20,"name":"来宾市","sort":0},{"id":3065,"p_id":1,"name":"延庆县","sort":0},{"id":3071,"p_id":30,"name":"中卫市","sort":0},{"id":3074,"p_id":6,"name":"长治市","sort":0},{"id":3080,"p_id":28,"name":"定西市","sort":0},{"id":3107,"p_id":26,"name":"那曲地区","sort":0},{"id":3115,"p_id":23,"name":"琼海市","sort":0},{"id":3129,"p_id":26,"name":"山南地区","sort":0},{"id":3137,"p_id":23,"name":"万宁市","sort":0},{"id":3138,"p_id":26,"name":"昌都地区","sort":0},{"id":3144,"p_id":26,"name":"日喀则地区","sort":0},{"id":3154,"p_id":17,"name":"神农架林区","sort":0},{"id":3168,"p_id":20,"name":"崇左市","sort":0},{"id":3173,"p_id":23,"name":"东方市","sort":0},{"id":3690,"p_id":23,"name":"三亚市","sort":0},{"id":3698,"p_id":23,"name":"文昌市","sort":0},{"id":3699,"p_id":23,"name":"五指山市","sort":0},{"id":3701,"p_id":23,"name":"临高县","sort":0},{"id":3702,"p_id":23,"name":"澄迈县","sort":0},{"id":3703,"p_id":23,"name":"定安县","sort":0},{"id":3704,"p_id":23,"name":"屯昌县","sort":0},{"id":3705,"p_id":23,"name":"昌江县","sort":0},{"id":3706,"p_id":23,"name":"白沙县","sort":0},{"id":3707,"p_id":23,"name":"琼中县","sort":0},{"id":3708,"p_id":23,"name":"陵水县","sort":0},{"id":3709,"p_id":23,"name":"保亭县","sort":0},{"id":3710,"p_id":23,"name":"乐东县","sort":0},{"id":3711,"p_id":23,"name":"三沙市","sort":0},{"id":3970,"p_id":26,"name":"阿里地区","sort":0},{"id":3971,"p_id":26,"name":"林芝地区","sort":0},{"id":4108,"p_id":25,"name":"迪庆州","sort":0},{"id":4110,"p_id":31,"name":"五家渠市","sort":0},{"id":4164,"p_id":4,"name":"城口县","sort":0},{"id":6858,"p_id":8,"name":"铁岭市","sort":0},{"id":15945,"p_id":31,"name":"阿拉尔市","sort":0},{"id":15946,"p_id":31,"name":"图木舒克市","sort":0},{"id":48131,"p_id":4,"name":"璧山县","sort":0},{"id":48132,"p_id":4,"name":"荣昌县","sort":0},{"id":48133,"p_id":4,"name":"铜梁县","sort":0},{"id":48201,"p_id":4,"name":"合川区","sort":0},{"id":48202,"p_id":4,"name":"巴南区","sort":0},{"id":48203,"p_id":4,"name":"北碚区","sort":0},{"id":48204,"p_id":4,"name":"江津区","sort":0},{"id":48205,"p_id":4,"name":"渝北区","sort":0},{"id":48206,"p_id":4,"name":"长寿区","sort":0},{"id":48207,"p_id":4,"name":"永川区","sort":0},{"id":50950,"p_id":4,"name":"江北区","sort":0},{"id":50951,"p_id":4,"name":"南岸区","sort":0},{"id":50952,"p_id":4,"name":"九龙坡区","sort":0},{"id":50953,"p_id":4,"name":"沙坪坝区","sort":0},{"id":50954,"p_id":4,"name":"大渡口区","sort":0},{"id":50995,"p_id":4,"name":"綦江区","sort":0},{"id":51026,"p_id":4,"name":"渝中区","sort":0},{"id":51027,"p_id":4,"name":"高新区","sort":0},{"id":51028,"p_id":4,"name":"北部新区","sort":0},{"id":51035,"p_id":3,"name":"东丽区","sort":0},{"id":51036,"p_id":3,"name":"和平区","sort":0},{"id":51037,"p_id":3,"name":"河北区","sort":0},{"id":51038,"p_id":3,"name":"河东区","sort":0},{"id":51039,"p_id":3,"name":"河西区","sort":0},{"id":51040,"p_id":3,"name":"红桥区","sort":0},{"id":51041,"p_id":3,"name":"蓟县","sort":0},{"id":51042,"p_id":3,"name":"静海县","sort":0},{"id":51043,"p_id":3,"name":"南开区","sort":0},{"id":51044,"p_id":3,"name":"塘沽区","sort":0},{"id":51045,"p_id":3,"name":"西青区","sort":0},{"id":51046,"p_id":3,"name":"武清区","sort":0},{"id":51047,"p_id":3,"name":"津南区","sort":0},{"id":51048,"p_id":3,"name":"汉沽区","sort":0},{"id":51049,"p_id":3,"name":"大港区","sort":0},{"id":51050,"p_id":3,"name":"北辰区","sort":0},{"id":51051,"p_id":3,"name":"宝坻区","sort":0},{"id":51052,"p_id":3,"name":"宁河县","sort":0},{"id":52993,"p_id":0,"name":"港澳","sort":0},{"id":52994,"p_id":52993,"name":"香港特别行政区","sort":0},{"id":52995,"p_id":52993,"name":"澳门特别行政区","sort":0},{"id":53090,"p_id":31,"name":"铁门关市","sort":0}]
     * tech_stack : [{"id":1,"pid":0,"name":"android开发"},{"id":2,"pid":0,"name":"Python"},{"id":3,"pid":0,"name":"LINUX"},{"id":4,"pid":0,"name":"C++"},{"id":5,"pid":0,"name":"iOS开发"},{"id":6,"pid":0,"name":"Java"},{"id":7,"pid":0,"name":"PHP"},{"id":8,"pid":0,"name":"JavaScript"},{"id":9,"pid":0,"name":"MySQL"},{"id":10,"pid":0,"name":"CSS3"},{"id":11,"pid":0,"name":"HTML5"},{"id":12,"pid":0,"name":"Bootstrap"},{"id":13,"pid":0,"name":"jQuery"},{"id":14,"pid":0,"name":"Sketch"},{"id":15,"pid":0,"name":"Axure"},{"id":16,"pid":0,"name":"3D Max"},{"id":17,"pid":0,"name":"Maya"},{"id":18,"pid":0,"name":"Photoshop"},{"id":19,"pid":0,"name":"SEO"},{"id":20,"pid":0,"name":"Socket"},{"id":21,"pid":0,"name":"Eclipse"},{"id":22,"pid":0,"name":"NoSQL"},{"id":23,"pid":0,"name":"Redis"},{"id":24,"pid":0,"name":"Maven"},{"id":25,"pid":0,"name":"Nginx"},{"id":26,"pid":0,"name":"JSP"},{"id":27,"pid":0,"name":"AE"},{"id":28,"pid":0,"name":"illustrator"},{"id":29,"pid":0,"name":"SEM"},{"id":30,"pid":0,"name":"React"},{"id":31,"pid":0,"name":"ReactNative"},{"id":32,"pid":0,"name":"Visual Studio"},{"id":33,"pid":0,"name":"Docker"},{"id":34,"pid":0,"name":"AngularJS"},{"id":35,"pid":0,"name":"3D Max"},{"id":36,"pid":0,"name":"CorelDRAW"},{"id":37,"pid":0,"name":"Flash"}]
     * title : [{"id":1,"name":"iOS开发"},{"id":2,"name":"Android开发"},{"id":3,"name":"前端开发"},{"id":4,"name":"后台开发"},{"id":5,"name":"产品经理"},{"id":6,"name":"设计师"},{"id":7,"name":"测试工程师"},{"id":8,"name":"运维工程师"},{"id":9,"name":"市场/销售"},{"id":10,"name":"运营"},{"id":11,"name":"其他"}]
     * exprience : [{"id":1,"name":"一年以内"},{"id":2,"name":"1-3年"},{"id":3,"name":"3-5年"},{"id":4,"name":"5-10年"},{"id":5,"name":"10年以上"}]
     * team_num : [{"id":1,"name":"5人以下"},{"id":2,"name":"5-10人"},{"id":3,"name":"10-15人"},{"id":4,"name":"15-20人"},{"id":5,"name":"20-50人"},{"id":6,"name":"50人以上"}]
     * term : {"1":"超过6个月","2":"3-6个月","3":"1-3个月","4":"少于1个月","5":"少于1周"}
     * urgency : {"1":"不紧急","2":"一般","3":"非常紧急"}
     */

    private TermBean term;
    private UrgencyBean urgency;
    private List<IndustryBean> industry;
    private List<CategoryBean> category;
    private List<UseTypeBean> use_type;
    private List<ProvinceCityBean> province_city;
    private List<TechStackBean> tech_stack;
    private List<TitleBean> title;
    private List<ExprienceBean> exprience;
    private List<TeamNumBean> team_num;

    public TermBean getTerm() {
        return term;
    }

    public void setTerm(TermBean term) {
        this.term = term;
    }

    public UrgencyBean getUrgency() {
        return urgency;
    }

    public void setUrgency(UrgencyBean urgency) {
        this.urgency = urgency;
    }

    public List<IndustryBean> getIndustry() {
        return industry;
    }

    public void setIndustry(List<IndustryBean> industry) {
        this.industry = industry;
    }

    public List<CategoryBean> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryBean> category) {
        this.category = category;
    }

    public List<UseTypeBean> getUse_type() {
        return use_type;
    }

    public void setUse_type(List<UseTypeBean> use_type) {
        this.use_type = use_type;
    }

    public List<ProvinceCityBean> getProvince_city() {
        return province_city;
    }

    public void setProvince_city(List<ProvinceCityBean> province_city) {
        this.province_city = province_city;
    }

    public List<TechStackBean> getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(List<TechStackBean> tech_stack) {
        this.tech_stack = tech_stack;
    }

    public List<TitleBean> getTitle() {
        return title;
    }

    public void setTitle(List<TitleBean> title) {
        this.title = title;
    }

    public List<ExprienceBean> getExprience() {
        return exprience;
    }

    public void setExprience(List<ExprienceBean> exprience) {
        this.exprience = exprience;
    }

    public List<TeamNumBean> getTeam_num() {
        return team_num;
    }

    public void setTeam_num(List<TeamNumBean> team_num) {
        this.team_num = team_num;
    }

    public static class TermBean {
        /**
         * 1 : 超过6个月
         * 2 : 3-6个月
         * 3 : 1-3个月
         * 4 : 少于1个月
         * 5 : 少于1周
         */

        @SerializedName("1")
        private String _$1;
        @SerializedName("2")
        private String _$2;
        @SerializedName("3")
        private String _$3;
        @SerializedName("4")
        private String _$4;
        @SerializedName("5")
        private String _$5;

        public String get_$1() {
            return _$1;
        }

        public void set_$1(String _$1) {
            this._$1 = _$1;
        }

        public String get_$2() {
            return _$2;
        }

        public void set_$2(String _$2) {
            this._$2 = _$2;
        }

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }

        public String get_$4() {
            return _$4;
        }

        public void set_$4(String _$4) {
            this._$4 = _$4;
        }

        public String get_$5() {
            return _$5;
        }

        public void set_$5(String _$5) {
            this._$5 = _$5;
        }
    }

    public static class UrgencyBean {
        /**
         * 1 : 不紧急
         * 2 : 一般
         * 3 : 非常紧急
         */

        @SerializedName("1")
        private String _$1;
        @SerializedName("2")
        private String _$2;
        @SerializedName("3")
        private String _$3;

        public String get_$1() {
            return _$1;
        }

        public void set_$1(String _$1) {
            this._$1 = _$1;
        }

        public String get_$2() {
            return _$2;
        }

        public void set_$2(String _$2) {
            this._$2 = _$2;
        }

        public String get_$3() {
            return _$3;
        }

        public void set_$3(String _$3) {
            this._$3 = _$3;
        }
    }

    public static class IndustryBean {
        /**
         * id : 1
         * pid : 0
         * name : 医疗卫生
         */

        private int id;
        private int pid;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class CategoryBean {
        /**
         * id : 1
         * pid : 0
         * name : 定制开发
         * icon : http://ofotn744c.bkt.clouddn.com/20170830/1713/定制开发.png
         */

        private int id;
        private int pid;
        private String name;
        private String icon;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    public static class UseTypeBean {
        /**
         * id : 1
         * pid : 0
         * name : 工具
         */

        private int id;
        private int pid;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ProvinceCityBean {
        /**
         * id : 1
         * p_id : 0
         * name : 北京
         * sort : 0
         */

        private int id;
        private int p_id;
        private String name;
        private int sort;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getP_id() {
            return p_id;
        }

        public void setP_id(int p_id) {
            this.p_id = p_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }

    public static class TechStackBean {
        /**
         * id : 1
         * pid : 0
         * name : android开发
         */

        private int id;
        private int pid;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TitleBean {
        /**
         * id : 1
         * name : iOS开发
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ExprienceBean {
        /**
         * id : 1
         * name : 一年以内
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class TeamNumBean {
        /**
         * id : 1
         * name : 5人以下
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
