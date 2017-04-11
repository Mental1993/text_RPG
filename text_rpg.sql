-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 11 Απρ 2017 στις 08:06:23
-- Έκδοση διακομιστή: 10.1.16-MariaDB
-- Έκδοση PHP: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `text_rpg`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `items`
--

CREATE TABLE `items` (
  `item_id` int(11) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `item_desc` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `items`
--

INSERT INTO `items` (`item_id`, `item_name`, `item_desc`) VALUES
(1, 'Dusty Key', 'You can barely see a dusty key lying on the floor, under a spider web.'),
(2, 'Fire Torch', 'On the wall, there is a Fire Torch. If only there was a way to light fire...'),
(3, 'Bronse Sword', 'A heavy two-handed sword.');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `rooms`
--

CREATE TABLE `rooms` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(50) NOT NULL,
  `room_desc` varchar(300) NOT NULL,
  `exit1` int(11) NOT NULL,
  `exit2` int(11) NOT NULL,
  `exit3` int(11) NOT NULL,
  `exit4` int(11) NOT NULL,
  `image` varchar(50) NOT NULL,
  `item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Άδειασμα δεδομένων του πίνακα `rooms`
--

INSERT INTO `rooms` (`room_id`, `room_name`, `room_desc`, `exit1`, `exit2`, `exit3`, `exit4`, `image`, `item`) VALUES
(1, 'Starting Room', 'Rusting spikes line the walls and ceiling of this chamber. The dusty floor shows no sign that the walls move over it, but you can see the skeleton of some humanoid impaled on some wall spikes nearby.', 0, 0, 2, 0, 'room1.jpg', 3),
(2, 'room 2 name', 'This room is so big, you can''t even see where it''s borders... Exits lie on every possible direction.', 1, 3, 6, 4, 'room2.png', 0),
(3, 'room 3 name', 'A small room with no exits other than the one you just got in...A Fire Torch lies on the ground...Well, this could be usefull..', 0, 0, 0, 2, 'room3.png', 0),
(4, 'room 4 name', 'This otherwise bare room has one distinguishing feature. The stone around one of the other doors has been pulled over its edges, as though the rock were as soft as clay and could be moved with fingers. The stone of the door and wall seems hastily molded together.', 0, 2, 5, 0, 'room4.jpg', 0),
(5, 'room 5 name', 'Fire crackles and pops in a small cooking fire set in the center of the room. The smoke from a burning rat on a spit curls up through a hole in the ceiling. Around the fire lie several fur blankets and a bag. It looks like someone camped here until not long ago, but then left in a hurry.', 4, 6, 0, 0, 'room5.png', 0),
(6, 'room 6 name', 'A flurry of bats suddenly flaps through the doorway, their screeching barely audible as they careen past your heads. They flap past you into the rooms and halls beyond. The room from which they came seems barren at first glance.', 2, 0, 7, 5, 'room6.jpg', 0),
(7, 'Room 7 ', 'The scent of earthy decay assaults your nose upon peering through the open door to this room. Smashed bookcases and their sundered contents litter the floor. Paper rots in mold-spotted heaps, and shattered wood grows white fungus.', 6, 0, 0, 8, 'room7.jpg', 0),
(8, 'Room 8', 'This tiny room holds a curious array of machinery. Winches and levers project from every wall, and chains with handles dangle from the ceiling. On a nearby wall, you note a pictogram of what looks like a scythe on a chain. ', 0, 7, 0, 0, 'room8.png', 0);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `curr_room` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`item_id`);

--
-- Ευρετήρια για πίνακα `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`room_id`);

--
-- Ευρετήρια για πίνακα `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `items`
--
ALTER TABLE `items`
  MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT για πίνακα `rooms`
--
ALTER TABLE `rooms`
  MODIFY `room_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT για πίνακα `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
