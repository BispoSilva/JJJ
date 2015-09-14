/**
 * 
 */


function save_local_data(){
	
	var db = openDatabase('mydb', '1.0', 'Test DB', 2 * 1024 * 1024);

	db.transaction(function (tx) {  
	   tx.executeSql('CREATE TABLE IF NOT EXISTS BOOKS (id unique, author,title, publisher, price)');
	   var SQL = 'INSERT INTO BOOKS (id, author, title, publisher, price) VALUES (' 
		 + $("#id" ).val()  + SQLString($("#author" ).val()) +
	   SQLString($("#title" ).val())  + SQLString($("#publisher").val()) + SQLString($("#price" ).val()) + ')';
	   console.log(SQL);
	   tx.executeSql(SQL);
	});
	
	function SQLString(strvalue) {
		return  ", '" + strvalue + "'";
	}
	
}