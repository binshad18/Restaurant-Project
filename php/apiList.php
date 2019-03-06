<?php
include_once 'db.php';


if(isset($_GET['cityid'])){

	$sql = "SELECT id,rest_name,image FROM restaurant_details WHERE c_id = {$_GET['cityid']}";


}




$result = $conn->query($sql);
$myArray = array();

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
    	$myArray[] = $row;
    }
} else {
    	$myArray = ("No data Found");
}
$jsonArray = array("restaurantlist" => $myArray);
echo json_encode($jsonArray);

?>