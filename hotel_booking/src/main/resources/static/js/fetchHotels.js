async function fetchHotels() {
    try {
        const response = await fetch('http://localhost:8080/api/hotels'); // Correct endpoint
        if (response.ok) {
            const hotels = await response.json();
            hotels.forEach(displayHotelCard); // Add each hotel as a card
        } else {
            alert('Failed to fetch hotels');
        }
    } catch (error) {
        console.error('Error fetching hotels:', error);
    }
}

/*Display a card*/
function displayHotelCard(hotel) {
    const dashboard = document.getElementById('dashboard');
    const card = document.createElement('div');
    card.className = 'card';
    card.innerHTML = `
        <img src="${hotel.imageUrl1}" alt="Hotel Image">
        <h3>${hotel.hotelName}</h3>
        <p>${hotel.description}</p>
        <p>Location: ${hotel.location}</p>
        <p>Price: $${hotel.price}/day</p>
        <p>Total Rooms: ${hotel.totalRooms}</p>
        <p>Street: ${hotel.street}</p>
        <p>Pin Code: ${hotel.pinCode}</p>
    `;
    dashboard.appendChild(card);
}
