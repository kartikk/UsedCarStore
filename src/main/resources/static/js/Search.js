$("#id_btn_search").click(function() {
	var searchKey = $("#id_searchtext").val();
	$.ajax({
		url : "/search",
		type : "get",
		data : {
			searchKey : searchKey
		},
		success : function(result) {
			console.log(result);
			populateSearchResults(result);
		},
		failure : function() {
			console.log("Failed");
		}
	});
});

function populateSearchResults(listings) {
	$("#id_search_results").empty();
	$("#listingsTemplate").tmpl(listings).appendTo("#id_search_results");
}