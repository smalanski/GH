/**
 * Main JavaScript file for Greenhouse Vegetable Tracker
 */

document.addEventListener('DOMContentLoaded', function() {
    // Initialize all Bootstrap tooltips
    const tooltips = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'));
    tooltips.map(function(tooltipTriggerEl) {
        return new bootstrap.Tooltip(tooltipTriggerEl);
    });
      // Auto-dismiss alerts after 5 seconds (except for alerts with 'no-auto-dismiss' class)
    setTimeout(function() {
        const alerts = document.querySelectorAll('.alert:not(.no-auto-dismiss)');
        alerts.forEach(function(alert) {
            const bsAlert = new bootstrap.Alert(alert);
            bsAlert.close();
        });
    }, 5000);
    
    // Add event listener for harvest date validation
    const plantingDateInput = document.getElementById('plantingDate');
    const harvestDateInput = document.getElementById('expectedHarvestDate');
    
    if (plantingDateInput && harvestDateInput) {
        plantingDateInput.addEventListener('change', function() {
            if (harvestDateInput.value) {
                validateHarvestDate();
            }
        });
        
        harvestDateInput.addEventListener('change', validateHarvestDate);
        
        function validateHarvestDate() {
            const plantingDate = new Date(plantingDateInput.value);
            const harvestDate = new Date(harvestDateInput.value);
            
            if (harvestDate <= plantingDate) {
                alert('Expected harvest date must be after planting date');
                harvestDateInput.value = '';
            }
        }
    }
    
    // Add current date to date inputs if they're empty
    const dateInputs = document.querySelectorAll('input[type="date"]');
    dateInputs.forEach(function(input) {
        if (!input.value && input.id === 'plantingDate') {
            const today = new Date();
            const formattedDate = today.toISOString().substr(0, 10);
            input.value = formattedDate;
        }
    });
});
