<?php
include_once 'db.php';


if(isset($_GET['restaurantid'])){

	$sql = "SELECT id,rest_name,image,address,mail,phone FROM restaurant_details WHERE id = {$_GET['restaurantid']}";
}

$a=mysqli_query($conn, $sql);
if(mysqli_num_rows($a)>0)
{
	$response["success"]="1";
	$row=mysqli_fetch_array($a);


$response['rid']=$row['id'];
$response['name']=$row['rest_name'];
$response['image']=$row['image'];
$response['address']=$row['address'];
$response['mail']=$row['mail'];
$response['phone']=$row['phone'];

                

	
} else {
	$response["success"]="0";
   
}


mysqli_close($conn);
$json=json_encode($response);
 echo $json;
?>