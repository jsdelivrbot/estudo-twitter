import _ from "lodash";
import React, { Component } from "react";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import { fetchIndicadores } from "../actions";

class PostsIndex extends Component {
  componentDidMount() {
    this.props.fetchIndicadores();
  }

  renderIndicadores() {
    return _.map(this.props.indicadores.topUsers, users => {
      return (
        <li className="list-group-item" key={users.id}>
            {users.id} - {users.quantidadeSeguidores} Seguidores
        </li>
      );
    });
  }

  render() {
    return (
      <div>
        <div className="text-xs-right">
          <Link className="btn btn-primary" to="/posts/new">
            Add a Post
          </Link>
        </div>
        <h3>Top 5 usuários</h3>
        <ul className="list-group">
          {this.renderIndicadores()}
        </ul>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return { indicadores: state.posts };
}

export default connect(mapStateToProps, { fetchIndicadores })(PostsIndex);
