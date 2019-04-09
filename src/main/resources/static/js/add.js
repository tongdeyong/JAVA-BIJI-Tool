define(function(require, exports, module) {

	var AjaxUtil = require('./util/AjaxUtil.js');
	var HandlebarsUtil = require('./util/HandlebarsUtil.js');

	/** 获取参数 */
	var getParam = function() {
		return {
			'id' : $('#idValue').val(),
			'contentClass' : $('#contentClass').val(),
			'parentTitle' : $('#parentTitle').val(),
			'subheading' : $('#subheading').val(),
			'description' : $('#description').val()
		};
	};

	/**
	 * 清空输入框
	 */
	var cleanData = function() {
		$('#subheading').val('');
		$('#description').val('');
	};

	/** 提交添加的信息 */
	var addData = function(url, type) {
		var data = getParam();
		AjaxUtil.ajaxPost(url, data, function() {
			
			if (type === 'add') {
				alert('添加成功！');
				cleanData();
			}else{
				alert('修改成功！');
			}
		}, function() {
			if (type === 'add') {
				alert('添加失败！');
			}else{
				alert('修改失败！');
			}
		})
	};

	/* 查询下拉选 */
	var queryChoose = function() {
		var url = './content/queryClass';
		AjaxUtil.ajaxGet(url, null, function(data) {
			var html = HandlebarsUtil.render('choose-template', data);
			$('#contentClass').append(html);
		}, function() {
			alert('分类查询异常！')
		})
	};

	return {
		addData : addData,
		queryChoose : queryChoose
	}
});