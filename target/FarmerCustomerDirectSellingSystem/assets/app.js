// Small client-side helper: asks before deleting a product or removing an item.
function confirmAction(message){return window.confirm(message);}
function filterCards(){const q=document.getElementById('localSearch').value.toLowerCase();document.querySelectorAll('[data-product]').forEach(card=>{card.style.display=card.innerText.toLowerCase().includes(q)?'':'none';});}