var speed = 4;

function showImage(src){
	var div = document.createElement("div");
	with (div.style){
		width = "700px";
		height = "700px";
		border = "2px solid black";
		textAlign = "center";
		overflow = "hidden";
		margin= "20px 20px 10px 500px";
	}
	document.body.appendChild(div);
	img = document.createElement("img");
	img.src = src;
	img.width = 700;
	img.height = 700;
	div.appendChild(img);
	img.addEventListener('mousewheel', eventHander,false);
	//img.margin-left = 200;
}

function eventHander(event){
	var k = 0;
	if (event.wheelDelta > 0) k = speed;
	if (event.wheelDelta < 0) k = -speed;
	if (event.wheelDelta !==0) {
		img.width = img.width + k;
		img.height = img.height + k;
		img.style.margin = ((700 - img.height) / 2).toString() + "px";
	}
}


function keyDown(key) {
	var k = 0;
	if (key === 187) k = speed;
	if (key === 189) k = -speed;
	if (key !== 0) {
		img.width = img.width + k;
		img.height = img.height + k;
		img.style.margin = ((700 - img.height) / 2).toString() + "px";
	}
}
