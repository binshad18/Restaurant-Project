<?php
include_once 'db.php';

$sql = "SELECT * from city";
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
$jsonArray = array("citieslist" => $myArray);
echo json_encode($jsonArray);

?>