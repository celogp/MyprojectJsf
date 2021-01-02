/**
 * 
 */

function showGrid() {
	let $thisGrid = $('.showGrid')
	let $thisForm = $('.showForm')
	
	if ($thisGrid.hasClass("hidden")) {
		$thisGrid.removeClass("hidden").addClass("visible");
		$thisForm.removeClass("visible").addClass("hidden");

	} else {
		$thisGrid.removeClass("visible").addClass("hidden");
		$thisForm.removeClass("hidden").addClass("visible");
	}

}