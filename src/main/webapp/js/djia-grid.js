  function change(val) {
    if (val > 0) {
      return '<span style="color:green;">' + val + '</span>';
    } else if (val < 0) {
      return '<span style="color:red;">' + val + '</span>';
    }
      return val;
  }

  function pctChange(val) {
    if (val > 0) {
      return '<span style="color:green;">' + val + '%</span>';
    } else if (val < 0) {
      return '<span style="color:red;">' + val + '%</span>';
    }
    return val;
  }

  var task = {
    run: function(){xmlStockStore.reload();},
    interval: 1000
  }

  var xmlStockStore = new Ext.data.XmlStore({
    autoDestroy : true,
    url : '../rest/djia',
    record : 'component',
    idPath : 'symbol',
    totalProperty : 'totalRecords',
    fields : [
      {name : 'name'},
      {name : 'price', type : 'float'},
      {name : 'valChange', type : 'float'},
      {name : 'pctChange', type : 'float'},
      {name : 'lastUpdate', type : 'date', dateFormat : 'Y-m-d H:i:s.u T'}
    ]
  });

  var gridView = new Ext.grid.GridView({
  	onLoad: Ext.emptyFn,
    listeners: {
      beforerefresh: function(v) {
       v.scrollTop = v.scroller.dom.scrollTop;
       v.scrollHeight = v.scroller.dom.scrollHeight;
      },
      refresh: function(v) {
       v.scroller.dom.scrollTop = v.scrollTop +
      (v.scrollTop == 0 ? 0 : v.scroller.dom.scrollHeight - v.scrollHeight);
      }
    }
  });

  var grid = new Ext.grid.GridPanel({
    view: gridView,
    store : xmlStockStore,
    columns : [
      {id : 'company', header : "Company", width : 160, sortable : true, dataIndex : 'name'},
      {header : "Price", width : 75, sortable : true, renderer : 'usMoney', dataIndex : 'price'},
      {header : "Change", width : 75, sortable : true, renderer : change, dataIndex : 'valChange'},
      {header : "% Change", width : 75, sortable : true, renderer : pctChange, dataIndex : 'pctChange'},
      {header : "Last Updated", width : 115, sortable : true, renderer : Ext.util.Format.dateRenderer('d-m-Y H:i:s'), dataIndex : 'lastUpdate'}
    ],
    stripeRows : true,
    autoExpandColumn : 'company',
    height : 620,
    width : 575,
    frame : true,
    scrollable: true,

    title : 'DJIA'
  });


Ext.onReady(function() {

	var connection = new Ext.data.Connection();

  var win = new Ext.Window({
    renderTo: Ext.getBody(),
    title:'Zone',
    height : 700,
    width : 590,
    plain:true,
    border:false,
    closable:false,
    buttonAlign:'center',
    layout:'fit',
    items:grid,
    buttons:[{
      text:'Start',
      iconCls:'icon-go',
      handler:function(){
        connection.request({
          url: '../control/refresh',
          method: 'POST',
          params: {"refresh": "start"},
          success: function(response, opts) {},
          failure: function(response, opts) {}
        });
      	Ext.TaskMgr.start(task);
      }
    },{
      text:'Stop',
      iconCls:'icon-stop',
      handler:function(){
        connection.request({
          url: '../control/refresh',
          method: 'POST',
          params: {"refresh": "stop"},
          success: function(response, opts) {},
          failure: function(response, opts) {}
        });
        Ext.TaskMgr.stop(task);
      }
    }]
  });

  xmlStockStore.load({params : {start : 0, limit : 30}});
  win.show();

});



