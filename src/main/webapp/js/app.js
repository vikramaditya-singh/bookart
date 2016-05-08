var HeaderCtrl = function($scope){
	$scope.appDetails = {
		title : "Bookart",
		tagline : "We have 1 million books for you"
	};
}


var BookListCtrl = function($scope){
	
	$scope.books = [{
		imgUrl: "RichDadPoorDad.jpeg",
		name : "Rich Dad Poor Dad",
		price : 227,
		rating : 4.5,
		binding : "Paperback",
		publisher : "Perseus Books Group (1 September 2011)",
		releaseDate : "1 Sep 2011",
		details : "Deemed to be one of the biggest bestsellers on finance across the globe, " +
				"Robert Kiyosaki's Rich Dad Poor Dad: What The Rich Teach Their Kids About Money " +
				"That The Poor And Middle Class Do Not! attempts to significantly change the manner " +
				"in which individuals view financial conceptions of appreciable money and investing. " +
				"The book also focuses on helping you attain financial freedom, apart from educating " +
				"" +
				"readers about the value of financial intelligence and financial literacy. " +
				"Some of the highlights of the book include the essence of wisely planning and " +
				"creating a thought out personal financial statement. It also helps in accurately " +
				"determining the differences that make a property an asset or a liability. Rich Dad Poor Dad " +
				"inspires you to think like the affluent; at least as far as money is concerned, while " +
				"giving you a deeper insight about the basic concepts of money. These are concepts that " +
				"the rich teach their children and that parents belonging to the other economic strata don't " +
				"teach to theirs. Get some straight talk about money, investing and entrepreneurship in " +
				"this hugely popular book. The book was published in 2011 and is available in mass " +
				"market paperback."	
				},
				{
					imgUrl: "TheMonkWhoSoldHisFerrari.jpeg",
					name : "The Monk Who Sold His Ferrari",
					price : 99,
					rating : 4.5,
					binding : "Paperback",
					publisher : "Jaico Publishing House; First edition (25 September 2003)",
					releaseDate : "25 Sep 2003",
					details : "The Monk Who Sold His Ferrari is a heart-warming and inspiring story " +
							"that offers you and thousands of other readers a simplistic method " +
							"to living your life the right way. This intriguing story concerns the life " +
							"of Julian Mantle, who is a highly successful lawyer. This lawyer is suddenly " +
							"brought face-to-face with his unbalanced life, when he has a heart attack, " +
							"which brings everything in his life to a standstill. On selling all that he " +
							"owns and journeying through India, Julian has a spiritual awakening, " +
							"concerning his disorderly life, because of which he decides to set things right, " +
							"by living life in a much more fulfilling way than he had been doing before."	
							}
	];
	
	
}