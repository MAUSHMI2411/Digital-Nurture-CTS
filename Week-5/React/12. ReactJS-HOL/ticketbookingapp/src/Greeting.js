import React from "react";

export function UserGreeting() {
  return <h2>Welcome back</h2>;
}

export function GuestGreeting() {
  return <h2>Please sign up.</h2>;
}

function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;

  if (isLoggedIn) {
    return <UserGreeting />;
  }

  return <GuestGreeting />;
}

export default Greeting;