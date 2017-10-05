// JavaScript Document

$(document).ready(function () {

$('[data-tip="tooltip"]').tooltip({
  container: 'body'
});
    var navListItems = $('div.setup-panel div a'),
            allWells = $('.setup-content'),
            allNextBtn = $('.nextBtn');

    allWells.hide();

    navListItems.click(function (e) {
        e.preventDefault();
        var $target = $($(this).attr('href')),
                $item = $(this);

        if (!$item.hasClass('disabled')) {
            navListItems.removeClass('btn-cosbtn').addClass('btn-default');
            $item.addClass('btn-cosbtn').removeClass('btn-default');
            allWells.hide();
            $target.show();
            $target.find('input:eq(0)').focus();
        }
    });

    allNextBtn.click(function(){
        var curStep = $(this).closest(".setup-content"),
            curStepBtn = curStep.attr("id"),
            nextStepWizard = $('div.setup-panel div a[href="#' + curStepBtn + '"]').parent().next().children("a"),
            curInputs = curStep.find("input[type='text'],input[type='url']"),
            isValid = true;

        $(".form-group").removeClass("has-error");
        for(var i=0; i<curInputs.length; i++){
            if (!curInputs[i].validity.valid){
                isValid = false;
                $(curInputs[i]).closest(".form-group").addClass("has-error");
            }
        }

        if (isValid)
            nextStepWizard.removeAttr('disabled').trigger('click');
    });

    $('div.setup-panel div a.btn-cosbtn').trigger('click');
	
	
	
	////Add address////
	
    var max_fields      = 10;
    var wrapper         = $(".input_fields_wrap");
    var add_button      = $(".add_field_button");
    
    var x = 1;
    $(add_button).click(function(e){
        e.preventDefault();
        if(x < max_fields){
            x++; 
            $(wrapper).append('<div class="form-group"><textarea class="form-control" rows="5" required placeholder="address 2"></textarea><a href="#" class="remove_field btn-link"><i class="fa fa-close"></i> Remove</a></div>'); //add input box
        }
		$(this).hide();
    });
    
    $(wrapper).on("click",".remove_field", function(e){
        e.preventDefault(); $(this).parent('div').remove(); x--;
		$(add_button).show();
    });
	
	
	////Add Company Specialties////
	
    var csmax_fields      = 10;
    var cswrapper         = $(".add_cs_field");
    var csadd_button      = $(".add_cs_field_button");
    
    var x = 1;
    $(csadd_button).click(function(ev){
        ev.preventDefault();
        if(x < csmax_fields){
            x++; 
            $(cswrapper).append(' <div class="row form-group"><div class="col-md-6"><input class="form-control" type="text" placeholder="company specialties"></div><div class="col-md-6"><input class="form-control" type="text" placeholder="company specialties"></div><a href="#" class="csremove_field btn-link"><i class="fa fa-close"></i> Remove</a></div>'); //add input box
        }
	
    });
    
    $(cswrapper).on("click",".csremove_field", function(ev){
        ev.preventDefault(); $(this).parent('div').remove(); x--;
		
    });



	////Add Key Skills////
	
    var ksmax_fields      = 10;
    var kswrapper         = $(".add_ks_field");
    var ks_btn      = $(".add_ks_field_button");
    
    var x = 1;
    $(ks_btn).click(function(ev){
        ev.preventDefault();
        if(x < ksmax_fields){
            x++; 
            $(kswrapper).append(' <div class="row form-group"><div class="col-md-6"><input class="form-control" type="text" placeholder=""></div><div class="col-md-6"><input class="form-control" type="text" placeholder=""></div><a href="#" class="ksremove_field btn-link"><i class="fa fa-close"></i> Remove</a></div>'); //add input box
        }
	
    });
    
    $(kswrapper).on("click",".ksremove_field", function(ev){
        ev.preventDefault(); $(this).parent('div').remove(); x--;
		
    });
	
	
	////Add Languages////
	
    var lgmax_fields      = 10;
    var lgwrapper         = $(".add_lg_field");
    var lg_btn      = $(".add_lg_field_button");
    
    var x = 1;
    $(lg_btn).click(function(ev){
        ev.preventDefault();
        if(x < lgmax_fields){
            x++; 
            $(lgwrapper).append(' <div class="row form-group"><div class="col-md-6"><input class="form-control" type="text" placeholder=""></div><div class="col-md-6"><input class="form-control" type="text" placeholder=""></div><a href="#" class="lgremove_field btn-link"><i class="fa fa-close"></i> Remove</a></div>'); //add input box
        }
	
    });
    
    $(lgwrapper).on("click",".lgremove_field", function(ev){
        ev.preventDefault(); $(this).parent('div').remove(); x--;
		
    });
	
	

    $('#list').click(function(event){
		event.preventDefault();
		$('.list-group-item .media, .list-group-item-text').addClass('hidden');
		$('.list-group-item #list-text').removeClass('col-md-8').addClass('col-md-10');
		$('a.list-group-item').css({
					'min-height' : '90px'	
			});
		});
    $('#grid').click(function(event){
		event.preventDefault();
		$('.list-group-item .media, .list-group-item-text').removeClass('hidden');
		$('.list-group-item #list-text').removeClass('col-md-10').addClass('col-md-8');
		$('a.list-group-item').css({
					'min-height' : '150px'	
			});
		});
		
		
		$( document.body ).on( 'click', '#slecet-dropdown-menu li', function( event ) {
 
   var $target = $( event.currentTarget );
 
   $target.closest( '.btn-group' )
      .find( '[data-bind="label"]' ).text( $target.text() )
         .end()
      .children( '.dropdown-toggle' ).dropdown( 'toggle' );
 
   return false;
 
});



$(window).scroll(function(){
  var sticky = $('.listgrid-header'),
      scroll = $(window).scrollTop();

  if (scroll >= 2) sticky.addClass('listgrid-header-fixed');
  else sticky.removeClass('listgrid-header-fixed');
});

$(window).scroll(function(){
  var sticky = $('.wrap-page-header'),
      scroll = $(window).scrollTop();

  if (scroll >= 2) sticky.addClass('page-header-fixed');
  else sticky.removeClass('page-header-fixed');
});

});