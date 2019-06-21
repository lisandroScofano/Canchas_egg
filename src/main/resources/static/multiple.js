/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$('#btnRight').click(function (e) {
    $('select').moveToListAndDelete('#lstBox1', '#lstBox2');
    e.preventDefault();
});

$('#btnAllRight').click(function (e) {
    $('select').moveAllToListAndDelete('#lstBox1', '#lstBox2');
    e.preventDefault();
});

$('#btnLeft').click(function (e) {
    $('select').moveToListAndDelete('#lstBox2', '#lstBox1');
    e.preventDefault();
});

$('#btnAllLeft').click(function (e) {
    $('select').moveAllToListAndDelete('#lstBox2', '#lstBox1');
    e.preventDefault();
});